package com.song.dao;

import java.util.List;
import java.util.Map;

import com.song.entity.Sale;

public interface SaleMapper {

	List<Sale> queryBypName(Map<Object, Object> map);

	List<Sale> queryByRegion(Map<Object, Object> map);

	void add(Map<Object, Object> map);

	void delete(String id);

}
