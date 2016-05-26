package com.song.web;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.song.DBUtils.JsonUtils;
import com.song.entity.User;
import com.song.service.UserService;

@Controller
public class SysController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/login")
	public void login(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String userName = null == request.getParameter("username")?"":request.getParameter("username");
		String password = null == request.getParameter("password")?"":request.getParameter("password");
		if(userName.equals("username")) {
			Cookie cookie = new Cookie("_PERMISSION", 1+"");
		    cookie.setPath("/");
		    cookie.setMaxAge(60 * 60);//必须设置时间，否则只在当前页面有效
		    response.addCookie(cookie);
		    request.getSession().setAttribute("_LOGIN", "OK");
			response.getWriter().write(JsonUtils.statusResponse(0,"toMain"));
		}else{
			if(userService.userExist(userName, password)){
				User user = userService.userQuery(userName);
				request.getSession().setAttribute("_LOGIN", "OK");
			    request.getSession().setAttribute("_USERNAME", userName);
			    Cookie cookie = new Cookie("_PERMISSION", user.getPermission()+"");
			    cookie.setPath("/");
			    cookie.setMaxAge(60 * 60);//必须设置时间，否则只在当前页面有效
			    response.addCookie(cookie);
				response.getWriter().write(JsonUtils.statusResponse(0,"toMain"));
			}else{
				response.getWriter().write(JsonUtils.statusResponse(1,"用户不存在"));
			}
		}
	}
	@RequestMapping(value="toMain")
	public String toMain(){
		return "main.html";
	}
	/**
	 * 系统登出
	 * @throws IOException 
	 */
	@RequestMapping(value="/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.getSession().invalidate();
		String PATH = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		response.sendRedirect(PATH);
	}
	
	@RequestMapping(value="/manage/configInit")
	public void configInit(@RequestParam String cmd,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		Properties prop=new Properties();         
		prop.load(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("select.properties"), "UTF-8"));  
		String proTypes = prop.getProperty("proTypes");
		String regions = prop.getProperty("regions");
		if(null!=cmd){
			if("proType".equals(cmd)){
				response.getWriter().write(JsonUtils.statusResponse(0, proTypes+"&"+regions));
			}
		}else response.getWriter().write(JsonUtils.statusResponse(1, "ERROR"));
	}
}
