package com.song.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	 */
	@RequestMapping(value="/add")
	public void add(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	/**
	 * 物流信息删除
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/delete")
	public void delete(HttpServletRequest request,HttpServletResponse response){
		
	}
}
