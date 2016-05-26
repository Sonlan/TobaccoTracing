package com.song.service;

import java.util.List;

import com.song.entity.Sale;

public interface SaleService {

	List<Sale> queryBypName(String pName);

	List<Sale> queryByRegion(String region);

}
