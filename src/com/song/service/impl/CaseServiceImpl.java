package com.song.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.dao.CaseMapper;
import com.song.entity.Case;
import com.song.service.CaseService;
@Service 
public class CaseServiceImpl implements CaseService {
	@Autowired
	private CaseMapper caseDao;
	@Override
	public List<Case> caseQuery(String id) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("id", id);
			return caseDao.query(map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean update(Case case1) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("cases", case1);
			caseDao.update(map);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean add(Case case1) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("cases", case1);
			caseDao.add(map);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean delete(String id) {
		try {
			caseDao.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
