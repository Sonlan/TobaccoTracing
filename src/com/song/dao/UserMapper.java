package com.song.dao;

import java.util.List;
import java.util.Map;

import com.song.entity.User;

public interface UserMapper {
	List<User> getUsers(Map<Object, Object> map);
    void deleteUserById(String id);
    /**
     * 根据用户名及密码判断是否存在此用户
     * @param map
     * @return
     */
    User userExist(Map<Object, Object> map);
    /**
     * 添加用户
     * @param map
     */
	void insert(Map<Object, Object> map);
	/**
	 * 用户名是否重复
	 * @param map
	 * @return
	 */
	User userRepeat(String userName);
	User getUserByName(Map<Object, Object> map);
	
	void updateUser(Map<Object, Object> map);
}
