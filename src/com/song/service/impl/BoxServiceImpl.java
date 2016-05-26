package com.song.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.dao.BoxMapper;
import com.song.entity.Box;
import com.song.service.BoxService;
@Service
public class BoxServiceImpl implements BoxService {
	@Autowired
	private BoxMapper boxDao;
	@Override
	public List<Box> boxQuery(String id) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("id", id);
			return boxDao.query(map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public boolean update(Box box) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("box", box);
			boxDao.update(map);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	@Override
	public boolean add(Box box) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("box", box);
			boxDao.add(map);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean delete(String id) {
		try {
			boxDao.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


}
