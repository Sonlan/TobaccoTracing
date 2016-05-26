package com.song.service;

import java.util.List;

import com.song.entity.User;

public interface UserService {
	User userQuery(String username);
	/**
	 * 用户信息查询
	 * @return 用户
	 */
	List<User> getUsers(String permission,String scopes);
	/**
	 * 用户信息更新
	 * @return 操作状态码
	 */
	int userUpdate(User user);
	/**
	 * 添加用户
	 * @param user
	 * @return 返回操作状态码
	 */
	int userAdd(User user);
	/**
	 * 用户删除
	 * @param id
	 * @return 操作状态码
	 */
	int userDelete(String id);
	
	boolean userExist(String userName,String password);
}
