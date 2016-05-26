package com.song.dao;

import java.util.List;
import java.util.Map;

import com.song.entity.StoreInfo;

public interface StoreInfoMapper {

	List<StoreInfo> queryBySid(Map<Object, Object> map);

	List<StoreInfo> queryByWHid(Map<Object, Object> map);

	void add(Map<Object, Object> map);

	void delete(String whid);

}
