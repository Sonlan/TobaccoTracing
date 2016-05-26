package com.song.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.FastArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.dao.LogisticMapper;
import com.song.entity.Logistic;
import com.song.service.LogisticService;
@Service
public class LogisticServiceImpl implements LogisticService {
	@Autowired
	private LogisticMapper logisticDao;
	@Override
	public List<Logistic> queryByid(String id) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("id", id);
			return logisticDao.queryById(map);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<Logistic> queryByLid(String lid, String remark) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("logisticsID", lid);
			map.put("remark", remark);
			return logisticDao.queryById(map);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<Logistic> queryByLid1(String lid, String caseID, String pid) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("logisticsID", lid);
			map.put("remark", caseID);
			map.put("remark1", pid);
			return logisticDao.queryById(map);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public boolean add(Logistic logistic) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("logistic", logistic);
			logisticDao.add(map);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean delete(String id) {
		try {
			logisticDao.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean update(Logistic logistic) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("logistic", logistic);
			logisticDao.update(map);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
