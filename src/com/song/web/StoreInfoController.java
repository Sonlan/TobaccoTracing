package com.song.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.song.entity.StoreInfo;
import com.song.service.StoreInfoService;
import com.song.util.JsonUtils;
import com.song.util.LabelValidate;

@Controller
@RequestMapping(value="/storeInfo")
public class StoreInfoController {
	@Autowired
	private StoreInfoService storeInfoService;
	@RequestMapping(value="/query")
	public void query(@RequestParam String type,@RequestParam String id,HttpServletResponse response) throws IOException{
		if(null != type){
			if(type.equals("selStoreIds")) response.getWriter().write(JsonUtils.statusResponse(1, storeInfoService.queryByWHid(id)));
			else if(type.equals("selInDates")) response.getWriter().write(JsonUtils.statusResponse(1, storeInfoService.queryByInDate(id)));
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
			String addNew = request.getParameter("addNew");//区分update和add函数

			String	inDate = request.getParameter("inDate");
			String	outDate = request.getParameter("outDate");

			
			StoreInfo stores = new StoreInfo();
			stores.setStoreID(request.getParameter("storeID"));
			stores.setWarehouseID(request.getParameter("warehouseID"));
			stores.setInDate(inDate);
			stores.setOutDate(outDate);
			stores.setPb(request.getParameter("pb"));
			stores.setState(request.getParameter("state"));
			stores.setLocation(request.getParameter("location"));
			stores.setRemark(request.getParameter("remark"));
			if(!LabelValidate.validate("W", stores.getWarehouseID())) {response.getWriter().write(JsonUtils.statusResponse(1, "仓储信息编号应以W开头"));return;}
			if(!LabelValidate.validate("S", stores.getStoreID())) {response.getWriter().write(JsonUtils.statusResponse(1, "仓储位置编号应以W开头"));return;}
			if(addNew!=null){
				if(!Boolean.parseBoolean(addNew)){//update
					if(storeInfoService.update(stores)){
						response.getWriter().write(JsonUtils.statusResponse(0, "修改成功"));
					}else{
						response.getWriter().write(JsonUtils.statusResponse(1, "修改失败"));
					}
				}else {//add
					if(storeInfoService.add(stores)){
						response.getWriter().write(JsonUtils.statusResponse(0, "新增成功"));
					}else{
						response.getWriter().write(JsonUtils.statusResponse(1, "新增失败"));
					}
				}
			}
			else response.getWriter().write(JsonUtils.statusResponse(1, "系统异常"));
			return;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.getWriter().write(JsonUtils.statusResponse(1, "系统异常"));
			return;
		}
	}
	
	/**
	 * 物流信息删除
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/delete")
	public void delete(@RequestParam String id,HttpServletResponse response) throws IOException{
		if(storeInfoService.delete(id))
			response.getWriter().write(JsonUtils.statusResponse(0, "删除成功"));
		else response.getWriter().write(JsonUtils.statusResponse(1, "删除失败"));
	}
}
