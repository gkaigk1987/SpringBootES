package com.gk.elasticsearch.searchservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.elasticsearch.ESRepository.ThesisRepository;
import com.gk.elasticsearch.esModel.ESThesis;

@Service
public class ThesisSearchService implements IThesisSearchService {
	
	@Autowired
	private ThesisRepository thesisRepository;

	@Override
	public List<ESThesis> getThesisByThesisCode(String thesisCode) {
		return thesisRepository.findByThesisCode(thesisCode);
	}

	@Override
	public void addThesisIndex(ESThesis esThesis) {
		thesisRepository.index(esThesis);
	}

	@Override
	public void addThesisListIndex(List<ESThesis> thesisList) {
		thesisRepository.saveAll(thesisList);
	}

}
