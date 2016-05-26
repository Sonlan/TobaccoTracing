package com.song.service;

import java.util.List;

import com.song.entity.Sale;

public interface SaleService {

	List<Sale> queryBypName(String pName);

	List<Sale> queryByRegion(String region);
	
	boolean add(Sale sale);
	
	boolean delete(String id);

	boolean update(Sale sale);

	List<Sale> query(String region, String pName);
}
