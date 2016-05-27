package com.song.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.song.entity.Logistic;
import com.song.entity.Product;
import com.song.service.LogisticService;
import com.song.service.ProductService;
import com.song.util.JsonUtils;
import com.song.util.LabelValidate;
/**
 * 物流信息响应页
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/logistics")
public class LogisticController {
	@Autowired
	private LogisticService logisticService;
	@Autowired
	private ProductService productService;
	/**
	 * 物流信息查询
	 * @param type
	 * @param id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/query")
	public void query(@RequestParam String type,@RequestParam String id,HttpServletResponse response) throws IOException{
		String pid = "";
		try {
			if(id.split("_").length>1)
				pid = id.split("_")[1];  //获取附加信息,产品ID，用于溯源区分物流信息
			else pid = "";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			pid = "";
		}
		id = id.split("_")[0];
		if(null != type){
			if(type.equals("id")) response.getWriter().write(JsonUtils.statusResponse(1, logisticService.queryByid(id)));
			else if(type.equals("lid")){
				if(!pid.equals("")){
					String prefix = pid.substring(0, 1).toUpperCase(); 
					if(prefix.equals("B")){//Box
						response.getWriter().write(JsonUtils.statusResponse(1,logisticService.queryByLid(id,pid)));
					}else if(prefix.equals("C")){//Case
						List<Logistic> list= logisticService.queryByLid(id,"");
						for(int i=0;i<list.size();i++){
							if(list.get(i).getRemark().substring(0, 1).equals("P") || (list.get(i).getRemark().substring(0, 1).equals("C") && !list.get(i).getRemark().equals(pid))) {list.remove(i);i--;}
							else{
								if(list.get(i).getState().equals("消费") && list.get(i).getRemark().substring(0, 1).equals("B")){
									list.get(i).setState("拆箱");
								}
							}
						}
						response.getWriter().write(JsonUtils.statusResponse(1,list));
					}
					else if(prefix.equals("P")){//product
						Product pro = productService.productQuery(pid).get(0);
						List<Logistic> list= logisticService.queryByLid1(id,pro.getCaseID(),pro.getId());
						for(int i=0;i<list.size();i++){
							if(list.get(i).getRemark().substring(0, 1).equals("B")){
								if(list.get(i).getState().equals("消费")){
									list.get(i).setState("拆箱");
								}
							}else if(list.get(i).getRemark().substring(0, 1).equals("C")){
								if(list.get(i).getState().equals("消费")){
									list.get(i).setState("拆盒");
								}
							}
						}
						response.getWriter().write(JsonUtils.statusResponse(1,list));
					}
				}
				else	response.getWriter().write(JsonUtils.statusResponse(1,logisticService.queryByLid(id, "")));
			}
		}else response.getWriter().write(JsonUtils.statusResponse(1,"系统异常"));
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
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			String addNew = request.getParameter("addNew");//区分update和add函数
			Logistic logistic = new Logistic();
			logistic.setId(Integer.parseInt(request.getParameter("id")));
			logistic.setAddress(request.getParameter("address"));
			logistic.setLogisticsID(request.getParameter("logisticsID"));
			logistic.setRemark(request.getParameter("remark"));
			logistic.setState(request.getParameter("state"));
			logistic.setTime(request.getParameter("time"));
			
			if(!LabelValidate.validate("L", logistic.getLogisticsID())) {response.getWriter().write(JsonUtils.statusResponse(1, "物流信息编号应以L开头"));return;}
			
			if(addNew!=null){
				if(!Boolean.parseBoolean(addNew)){//update
					if(logisticService.update(logistic)){
						response.getWriter().write(JsonUtils.statusResponse(0, "OK"));
					}else{
						response.getWriter().write(JsonUtils.statusResponse(1, "更新失败"));
					}
				}else {//add
					if(logisticService.add(logistic)){
						response.getWriter().write(JsonUtils.statusResponse(0, "新增成功"));
					}else{
						response.getWriter().write(JsonUtils.statusResponse(1, "新增记录失败"));
					}
				}
			}
			else response.getWriter().write(JsonUtils.statusResponse(1, "系统异常"));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.getWriter().write(JsonUtils.statusResponse(1, "后台错误"));
		}
	}
	
	/**
	 * 物流信息删除
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam String id,HttpServletResponse response) throws IOException{
		if(logisticService.delete(id))
			response.getWriter().write(JsonUtils.statusResponse(0, "删除成功"));
		else response.getWriter().write(JsonUtils.statusResponse(1, "删除失败"));
	}
}
