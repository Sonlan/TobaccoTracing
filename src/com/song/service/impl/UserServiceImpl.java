package com.song.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.dao.UserMapper;
import com.song.entity.User;
import com.song.service.UserService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userDao;
	@Override
	public List<User> getUsers(String permission,String scopes) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("permission", permission);
			map.put("scopes", scopes);
			return userDao.getUsers(map);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public int userUpdate(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userAdd(User user) {
		try {
			if(null!=userDao.userRepeat(user.getUserName())) return 2;
			Map<Object, Object> map = new HashMap<>();
			map.put("user", user);
			userDao.insert(map);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
		
	}

	@Override
	public int userDelete(String id) {
		try {
			userDao.deleteUserById(id);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
		
	}

	@Override
	public boolean userExist(String userName, String password) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("userName", userName);
			map.put("password", password);
			if(null == userDao.userExist(map)) return false;
			else return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User userQuery(String username) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("userName", username);
			return userDao.getUserByName(map);
		} catch (Exception e) {
			return null;
		}
	}

}
