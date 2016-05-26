package com.song.service;

import java.util.List;

import com.song.entity.Box;

public interface BoxService {
	/**
	 * 按id查询box信息
	 * @param id
	 * @return
	 */
	List<Box> boxQuery(String id);

	boolean update(Box box);

	boolean add(Box box);

	boolean delete(String id);
}
