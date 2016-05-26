package com.song.service;

import java.util.List;

import com.song.entity.Logistic;

public interface LogisticService {

	List<Logistic> queryByid(String id);

	List<Logistic> queryByLid(String lid, String remark);

	List<Logistic> queryByLid1(String lid, String caseID, String pid);

}
