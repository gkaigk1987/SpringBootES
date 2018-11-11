package com.gk.elasticsearch.ESRepository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.gk.elasticsearch.esModel.ESThesis;
import java.lang.String;
import java.util.List;

public interface ThesisRepository extends ElasticsearchRepository<ESThesis, Long> {
	
	public List<ESThesis> findByThesisCode(String thesisCode);
	
}
