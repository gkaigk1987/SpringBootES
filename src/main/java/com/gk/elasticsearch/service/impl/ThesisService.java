package com.gk.elasticsearch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.elasticsearch.mapper.ThesisMapper;
import com.gk.elasticsearch.model.Thesis;
import com.gk.elasticsearch.service.IThesisService;

@Service
public class ThesisService implements IThesisService {

	@Autowired
	private ThesisMapper thesisMapper;
	
	@Override
	public Thesis getThesisById(Long id) {
		return thesisMapper.selectByPrimaryKey(id);
	}

}
