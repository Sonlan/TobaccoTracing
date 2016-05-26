package com.song.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.dao.SaleMapper;
import com.song.entity.Sale;
import com.song.service.SaleService;
@Service
public class SaleServiceImpl implements SaleService {
	@Autowired
	private SaleMapper saleDao;
	@Override
	public List<Sale> queryBypName(String pName) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("pName", pName);
			return saleDao.queryBypName(map);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Sale> queryByRegion(String region) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("region", region);
			return saleDao.queryByRegion(map);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean add(Sale sale) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("sale", sale);
			saleDao.add(map);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(String id) {
		try {
			saleDao.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
