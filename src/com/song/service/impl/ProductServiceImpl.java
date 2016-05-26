package com.song.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.dao.ProductMapper;
import com.song.entity.Product;
import com.song.service.ProductService;
@Service 
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productDao;
	@Override
	public List<Product> productQuery(String id) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("id", id);
			return productDao.query(map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean update(Product pro) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("pro", pro);
			productDao.update(map);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean add(Product pro) {
		try {
			Map<Object, Object> map = new HashMap<>();
			map.put("pro", pro);
			productDao.add(map);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean delete(String id) {
		try {
			productDao.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
