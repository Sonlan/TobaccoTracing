package com.song.dao;

import java.util.List;
import java.util.Map;

import com.song.entity.Box;

public interface BoxMapper {
	/**
	 * 按id查询
	 * @param map
	 * @return
	 */
	List<Box> query(Map<Object, Object> map);

	void update(Map<Object, Object> map);

	void add(Map<Object, Object> map);

	void delete(String id);
}
