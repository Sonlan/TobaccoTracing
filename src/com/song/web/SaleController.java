package com.song.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.song.entity.Sale;
import com.song.service.SaleService;
import com.song.util.JsonUtils;

@Controller
@RequestMapping(value="/salesInfo")
public class SaleController {
	@Autowired
	private SaleService saleService;
	@RequestMapping(value="/query")
	public void query(@RequestParam String type,@RequestParam String id,HttpServletResponse response) throws IOException{
		if(type!=null){
			if(type.equals("selpName")) response.getWriter().write(JsonUtils.statusResponse(0, saleService.queryBypName(id)));
			else if(type.equals("selRegion")) response.getWriter().write(JsonUtils.statusResponse(0, saleService.queryByRegion(id)));
		}else{
			response.getWriter().write(JsonUtils.statusResponse(1,"系统异常"));
		}
	}
	
	/**
	 * 物流信息新增
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/update")
	public void add(HttpServletRequest request,HttpServletResponse response) throws IOException{
		try{
			String addNew = request.getParameter("addNew");//区分update和add函数			
			Sale sale = new Sale();
			sale.setId(Integer.parseInt(request.getParameter("id")));
			sale.setRegion(request.getParameter("region"));
			sale.setpName(request.getParameter("pName"));
			sale.setTime(request.getParameter("time"));
			sale.setNum(Integer.parseInt(request.getParameter("num")));
			if(addNew!=null){
				if(!Boolean.parseBoolean(addNew)){//update
					if(saleService.update(sale)){
						response.getWriter().write(JsonUtils.statusResponse(0, "修改成功"));
					}else{
						response.getWriter().write(JsonUtils.statusResponse(1, "修改失败"));
					}
				}else {//add
					if(saleService.add(sale)){
						response.getWriter().write(JsonUtils.statusResponse(0, "新增成功"));
					}else{
						response.getWriter().write(JsonUtils.statusResponse(1, "新增失败"));
					}
				}
			}
			else response.getWriter().write(JsonUtils.statusResponse(1, "系统异常"));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.getWriter().write(JsonUtils.statusResponse(1, "系统异常"));
		}
	}
	
	/**
	 * 物流信息删除
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam String id,HttpServletResponse response) throws IOException{
		if(saleService.delete(id))
			response.getWriter().write(JsonUtils.statusResponse(0, "删除成功"));
		else response.getWriter().write(JsonUtils.statusResponse(1, "删除失败"));
	}
	
	@RequestMapping(value="/dataAnalysis")
	public void dataAnalysis(@RequestParam String type,@RequestParam String region,HttpServletResponse response) throws IOException{
		List<Sale> list = new ArrayList<Sale>();
		//按箱搜索
		if(!type.equals("")){//非空
			if(!region.equals("")){//地区产品销量趋势图
				response.getWriter().write(JsonUtils.statusResponse(1, queryByTime(region, type)));
				
			}else{//按产品种类查询地域销量分布
				response.getWriter().write(JsonUtils.statusResponse(1, queryByregion(type)));
			}
		}else{
			if(!region.equals("")){//按地区查询不同产品销量分布
				response.getWriter().write(JsonUtils.statusResponse(1, queryByAddr(region)));				
			}else{//查询无效
				response.getWriter().write(JsonUtils.statusResponse(1, "both are null"));				
			}
		}
	}
	
	/**
	 * 按地域查询，得到一种商品在全国各省市的销量分布
	 * @param pName 产品名
	 * @return int [34] 按特定顺序的34个省级单位的销售额
	 */
	private HashMap<String , Integer> queryByregion(String pName){
		List<Sale> list = new ArrayList<Sale>();
		list = saleService.queryBypName(pName);  //去除相应产品的所有销售记录
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for(int i=0;i<list.size();i++){//依次遍历取得的数据，统计各地区销售额
			result.put(list.get(i).getRegion(), list.get(i).getNum());
		}
		return result;
	} 
	/**
	 * 按产品查询，得到某一地区所有在册产品的销量分布
	 * @param region 地域名
	 * @return result 当前地域下，所有产品的销售额
	 */
	private HashMap<String , Integer> queryByAddr(String region){
		List<Sale> list = new ArrayList<Sale>();
		if("中国".equals(region.trim())) list = saleService.queryByRegion("");
		else list = saleService.queryByRegion(region);  //某地相应产品的所有销售记录
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for(int i=0;i<list.size();i++){//依次遍历取得的数据，统计各地区销售额
			if(result.containsKey(list.get(i).getpName()))
				result.put(list.get(i).getpName(), list.get(i).getNum()+result.get(list.get(i).getpName()));
			else result.put(list.get(i).getpName(), list.get(i).getNum());
		}
		return result;
	}
	/**
	 * 用于查询某产品在某地区的销量变化趋势图
	 * @param region 地区
	 * @param pName  品名
	 * @return （时间，销量）
	 */
	private Map<String , Integer> queryByTime(String region,String pName){
		List<Sale> list = new ArrayList<Sale>();
		if("中国".equals(region.trim())) list = saleService.queryBypName(pName);
		else list = saleService.query(region,pName);  //某地相应产品的所有销售记录
		Date date = new Date();
		int year = date.getYear()+1900;
		Map<String, Integer> result = new LinkedHashMap<>();
		for(int i=0;i<12;i++){
			result.put(year+"-"+(i+1), 0);
		}
		if(null != list){
			for(int i=0;i<list.size();i++){//依次遍历取得的数据，统计各地区销售额
				if(result.containsKey(list.get(i).getTime()))
					result.put(list.get(i).getTime(), list.get(i).getNum()+result.get(list.get(i).getTime()));
			}
			return result;
		}else return null;
	}
}
