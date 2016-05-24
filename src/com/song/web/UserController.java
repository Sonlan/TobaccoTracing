package com.song.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.song.DBUtils.JsonUtils;
import com.song.service.UserService;

/**
 * 用户管理页面
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 用户信息查询
	 * @param permission
	 * @param scopes
	 * @throws IOException 
	 */
	@RequestMapping(value="/query")
	public void query(@RequestParam String permission,@RequestParam String scopes,HttpServletResponse response) throws IOException{
		permission = null==permission?"":permission;
		scopes = null==scopes?"":scopes;
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(JsonUtils.statusResponse(0, userService.getUsers(permission, scopes)));
	}
	
}
