package com.song.dao;

import java.util.List;
import java.util.Map;

import com.song.entity.Logistic;

public interface LogisticMapper {

	List<Logistic> queryById(Map<Object, Object> map);
	List<Logistic> queryByLid(Map<Object, Object> map);
	List<Logistic> queryByLid1(Map<Object, Object> map);
	void add(Map<Object, Object> map);
	void delete(String id);
	void update(Map<Object, Object> map);
}
