package com.song.service;

import java.util.List;

import com.song.entity.StoreInfo;


public interface StoreInfoService {

	List<StoreInfo> queryByWHid(String whid);

	List<StoreInfo> queryByInDate(String storeID);

}
