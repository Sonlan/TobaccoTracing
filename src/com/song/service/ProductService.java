package com.song.service;

import java.util.List;

import com.song.entity.Product;

public interface ProductService {
	/**
	 * 按id查询box信息
	 * @param id
	 * @return
	 */
	List<Product> productQuery(String id);

	boolean update(Product pro);

	boolean add(Product pro);

	boolean delete(String id);
}
