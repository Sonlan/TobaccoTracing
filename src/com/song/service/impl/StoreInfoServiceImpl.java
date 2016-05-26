package com.song.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.dao.StoreInfoMapper;
import com.song.entity.StoreInfo;
import com.song.service.StoreInfoService;
@Service
public class StoreInfoServiceImpl implements StoreInfoService {
	@Autowired
	private StoreInfoMapper storeinfoDao;
	@Override
	public List<StoreInfo> queryByWHid(String whid) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("warehouseID", whid);
			return storeinfoDao.queryByWHid(map);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<StoreInfo> queryByInDate(String storeID) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("storeID", storeID);
			return storeinfoDao.queryBySid(map);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean add(StoreInfo storeInfo) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("storeInfo", storeInfo);
			storeinfoDao.add(map);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(String whid) {
		try {
			storeinfoDao.delete(whid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
