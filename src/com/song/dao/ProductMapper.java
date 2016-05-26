package com.song.dao;

import java.util.List;
import java.util.Map;

import com.song.entity.Product;

public interface ProductMapper {

	List<Product> query(Map<Object, Object> map);

	void add(Map<Object, Object> map);

	void update(Map<Object, Object> map);

	void delete(String id);

}
