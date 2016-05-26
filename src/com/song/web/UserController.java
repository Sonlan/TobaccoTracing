package com.song.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.song.entity.User;
import com.song.service.UserService;
import com.song.util.JsonUtils;

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
	/**
	 * 新增用户
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("application/json;charset=utf-8");
		String userName=null==request.getParameter("userName")?"":request.getParameter("userName");
		String password=null==request.getParameter("password")?"":request.getParameter("password");
		String permission=null==request.getParameter("permission")?"":request.getParameter("permission");
		String scopes=null==request.getParameter("scopes")?"":request.getParameter("scopes");
		String name=null==request.getParameter("name")?"":request.getParameter("name");
		String email=null==request.getParameter("email")?"":request.getParameter("email");
		String phoneNumber=null==request.getParameter("phoneNumber")?"":request.getParameter("phoneNumber");
		String remark=null==request.getParameter("remark")?"":request.getParameter("remark");
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setPermission(Integer.parseInt(permission));
		user.setScopes(scopes);
		user.setName(name);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setRemark(remark);
		if(0==userService.userAdd(user)){
			response.getWriter().write(JsonUtils.statusResponse(0, "新增用户成功"));
		}else if(1==userService.userAdd(user)){
			response.getWriter().write(JsonUtils.statusResponse(1, "新增用户失败"));
		}else{
			response.getWriter().write(JsonUtils.statusResponse(1, "用户名已存在"));
		}
	}
	/**
	 * 删除用户
	 * @throws IOException 
	 */
	@RequestMapping(value="/delete")
	public String  delete(@RequestParam String id,HttpServletResponse response) throws IOException{
		userService.userDelete(id);
		return "peopleManage.jsp";
	}
	/**
	 * 查看个人信息
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/aboutSelf")
	public void aboutSelf(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String username = (String) request.getSession().getAttribute("_USERNAME");
		response.getWriter().write(JsonUtils.statusResponse(1, userService.userQuery(username)));
	}
}
