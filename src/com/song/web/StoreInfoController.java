package com.song.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.song.service.StoreInfoService;
import com.song.util.JsonUtils;

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
}
