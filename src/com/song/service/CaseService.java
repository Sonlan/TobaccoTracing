package com.song.service;

import java.util.List;

import com.song.entity.Case;

public interface CaseService {
	/**
	 * 按id查询case信息
	 * @param id
	 * @return
	 */
	List<Case> caseQuery(String id);

	boolean update(Case case1);

	boolean add(Case case1);

	boolean delete(String id);
}
