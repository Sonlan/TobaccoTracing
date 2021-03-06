package com.song.web;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.song.entity.Box;
import com.song.entity.Case;
import com.song.entity.Product;
import com.song.service.BoxService;
import com.song.service.CaseService;
import com.song.service.ProductService;
import com.song.util.JsonUtils;
import com.song.util.LabelValidate;

/**
 * 产品信息管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	private BoxService boxService;
	@Autowired
	private CaseService caseService;
	@Autowired
	private ProductService productService;
	/**
	 * 产品信息查询
	 * @param type
	 * @param id
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/query")
	public void query(@RequestParam String type,@RequestParam String id,HttpServletResponse response) throws IOException{
		type = null==type?"":type;
		id = null==id?"":id;
		if(type.equals("boxID")){
			response.getWriter().write(JsonUtils.statusResponse(0, boxService.boxQuery(id)));
		}else if(type.equals("caseID")){
			response.getWriter().write(JsonUtils.statusResponse(0, caseService.caseQuery(id)));
		}else if(type.equals("productID")){
			response.getWriter().write(JsonUtils.statusResponse(0, productService.productQuery(id)));
		}else{
			response.getWriter().write(JsonUtils.statusResponse(1, "系统异常"));
		}
	}
	/**
	 * 产品信息更新
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/update")
	public void update(@RequestParam String type,@RequestParam String addNew,HttpServletRequest request, HttpServletResponse response) throws IOException{
		String pd = request.getParameter("pd");
		String logisticsId = request.getParameter("logisticsId");
		String gp = request.getParameter("gp");
		String manufacturer = request.getParameter("manufacturer");
		String pb = request.getParameter("pb");
		String pName = request.getParameter("pName");
		String amount = request.getParameter("amount");
		String price = "".equals(request.getParameter("price"))?"0":request.getParameter("price");
		String state = request.getParameter("state");
		String targetAddr = request.getParameter("targetAddr");
		String consumeAddr = request.getParameter("consumeAddr");
		String consumeTime = request.getParameter("consumeTime");
		String remark = request.getParameter("remark");
		if(type.equals("boxID")){
			String boxID = request.getParameter("boxID");
			String storeID = request.getParameter("storeID");
			
			if(!LabelValidate.validate("B", boxID)) {response.getWriter().write(JsonUtils.statusResponse(1, "箱体编号应以B开头"));return;}
			Box box = new Box();
			box.setPd(pd);
			box.setLogisticsId(logisticsId);
			box.setGp(gp);
			box.setManufacturer(manufacturer);
			box.setPb(pb);
			box.setpName(pName);
			box.setAmount(Integer.parseInt(amount));
			box.setPrice(Float.parseFloat(price));
			box.setState(state);
			box.setTargetAddr(targetAddr);
			box.setConsumeAddr(consumeAddr);
			box.setConsumeTime(consumeTime);
			box.setRemark(remark);
			box.setBoxID(boxID);
			box.setStoreID(storeID);
			if(Boolean.parseBoolean(addNew)){
				if(boxService.add(box)){
					response.getWriter().write(JsonUtils.statusResponse(0, "添加成功"));
				}else {
					response.getWriter().write(JsonUtils.statusResponse(1, "添加失败"));
				}
			}else{
				if(boxService.update(box)){
					response.getWriter().write(JsonUtils.statusResponse(0, "修改成功"));
				}else {
					response.getWriter().write(JsonUtils.statusResponse(1, "修改失败"));
				}
			}
			
		}else if(type.equals("caseID")){
			String caseID = request.getParameter("caseID");
			String boxID = request.getParameter("boxID");
			
			if(!LabelValidate.validate("C", caseID)) {response.getWriter().write(JsonUtils.statusResponse(1, "盒体编号应以C开头"));return;}
			Case case1 = new Case();
			case1.setPd(pd);
			case1.setLogisticsId(logisticsId);
			case1.setGp(gp);
			case1.setManufacturer(manufacturer);
			case1.setPb(pb);
			case1.setpName(pName);
			case1.setAmount(Integer.parseInt(amount));
			case1.setPrice(Float.parseFloat(price));
			case1.setState(state);
			case1.setTargetAddr(targetAddr);
			case1.setConsumeAddr(consumeAddr);
			case1.setConsumeTime(consumeTime);
			case1.setRemark(remark);
			case1.setCaseID(caseID);
			case1.setBoxID(boxID);
			if(Boolean.parseBoolean(addNew)){
				if(caseService.add(case1)){
					response.getWriter().write(JsonUtils.statusResponse(0, "添加成功"));
				}else {
					response.getWriter().write(JsonUtils.statusResponse(1, "添加失败"));
				}
			}else{
				if(caseService.update(case1)){
					response.getWriter().write(JsonUtils.statusResponse(0, "修改成功"));
				}else {
					response.getWriter().write(JsonUtils.statusResponse(1, "修改失败"));
				}
			}
		}else if(type.equals("productID")){
			String id = request.getParameter("id");
			String caseID = request.getParameter("caseID");
			String pl = request.getParameter("pl");
			String pa = request.getParameter("pa");
			String ranges = request.getParameter("range");
			String material = request.getParameter("material");
			
			if(!LabelValidate.validate("P", id)) {response.getWriter().write(JsonUtils.statusResponse(1, "产品编号应以P开头"));return;}
			
			Product pro = new Product();
			pro.setPd(pd);
			pro.setLogisticsId(logisticsId);
			pro.setGp(gp);
			pro.setManufacturer(manufacturer);
			pro.setPb(pb);
			pro.setpName(pName);
			pro.setPrice(Float.parseFloat(price));
			pro.setState(state);
			pro.setTargetAddr(targetAddr);
			pro.setConsumeAddr(consumeAddr);
			pro.setConsumeTime(consumeTime);
			pro.setRemark(remark);
			pro.setId(id);
			pro.setCaseID(caseID);
			pro.setPl(pl);
			pro.setPa(pa);
			pro.setRanges(ranges);
			pro.setMaterial(material);
			if(Boolean.parseBoolean(addNew)){
				if(productService.add(pro)){
					response.getWriter().write(JsonUtils.statusResponse(0, "添加成功"));
				}else {
					response.getWriter().write(JsonUtils.statusResponse(1, "添加失败"));
				}
			}else{
				if(productService.update(pro)){
					response.getWriter().write(JsonUtils.statusResponse(0, "修改成功"));
				}else {
					response.getWriter().write(JsonUtils.statusResponse(1, "修改失败"));
				}
			}
		}else{
			response.getWriter().write(JsonUtils.statusResponse(1, "系统异常"));
		}
	}
	/**
	 * 产品信息删除
	 * @param type
	 * @param id
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam String type, @RequestParam String id,HttpServletResponse response) throws IOException{
		if(type.equals("boxID")){
			if(boxService.delete(id)){
				response.getWriter().write(JsonUtils.statusResponse(0, "删除成功"));
			}else{
				response.getWriter().write(JsonUtils.statusResponse(1, "删除失败"));
			}
		}else if(type.equals("caseID")){
			if(caseService.delete(id)){
				response.getWriter().write(JsonUtils.statusResponse(0, "删除成功"));
			}else{
				response.getWriter().write(JsonUtils.statusResponse(1, "删除失败"));
			}
		}else if(type.equals("productID")){
			if(productService.delete(id)){
				response.getWriter().write(JsonUtils.statusResponse(0, "删除成功"));
			}else{
				response.getWriter().write(JsonUtils.statusResponse(1, "删除失败"));
			}
		}else{
			response.getWriter().write(JsonUtils.statusResponse(1, "系统异常"));
		}
	}
	/**
	 * 防伪查询
	 * @param id
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="antiFake")
	public void antiFake(@RequestParam String id,HttpServletResponse response) throws IOException{
		if(id!=null){
			String key = id.trim().toUpperCase().substring(0, 1);  //截取首字符
			if(key.equals("P")){//产品
				response.getWriter().write(JsonUtils.statusResponse(0,productService.productQuery(id).get(0)));
			}else if(key.equals("B")){
				response.getWriter().write(JsonUtils.statusResponse(0,boxService.boxQuery(id).get(0)));
			}else if(key.equals("C")){
				response.getWriter().write(JsonUtils.statusResponse(0,caseService.caseQuery(id).get(0)));
			}else response.getWriter().write(JsonUtils.statusResponse(1,"请输入有效查询码"));
		}
	}
}
