package com.gk.elasticsearch.searchservice;

import java.util.List;

import com.gk.elasticsearch.esModel.ESThesis;

public interface IThesisSearchService {

	public List<ESThesis> getThesisByThesisCode(String thesisCode);
	
	public void addThesisIndex(ESThesis esThesis);
	
	public void addThesisListIndex(List<ESThesis> thesisList);
}
