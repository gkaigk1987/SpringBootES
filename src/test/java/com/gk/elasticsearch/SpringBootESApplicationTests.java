package com.gk.elasticsearch;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gk.elasticsearch.esModel.ESThesis;
import com.gk.elasticsearch.model.Thesis;
import com.gk.elasticsearch.searchservice.IThesisSearchService;
import com.gk.elasticsearch.service.IThesisService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootESApplicationTests {
	
	@Autowired
	private IThesisSearchService thesisSearchService;
	
	@Autowired
	private IThesisService thesisService;

	@Test
	public void testGetThesisById() {
		Thesis thesis = thesisService.getThesisById(271961L);
		System.out.println(thesis.getThesisTitle());
	}
	
	@Test
	public void testESGetThesisByCode() {
		List<ESThesis> list = thesisSearchService.getThesisByThesisCode("U574626");
		list.stream().forEach(e -> {
			System.out.println(e.getTitle());
		});
	}
	
	@Test
	public void testESIndexThesis() {
		ESThesis esThesis = new ESThesis();
		esThesis.setId(1L);
		esThesis.setThesisCode("gk_test_thesis_code");
		esThesis.setTitle("gk_test_thesis_title");
		thesisSearchService.addThesisIndex(esThesis);
	}
	
	@Test
	public void testESIndexThesisList() {
		List<ESThesis> list = new ArrayList<>();
		ESThesis esThesis = new ESThesis();
		esThesis.setId(2L);
		esThesis.setThesisCode("gk_test_thesis_code1");
		esThesis.setTitle("gk_test_thesis_title1");
		list.add(esThesis);
		esThesis = new ESThesis();
		esThesis.setId(3L);
		esThesis.setThesisCode("gk_test_thesis_code2");
		esThesis.setTitle("gk_test_thesis_title2");
		list.add(esThesis);
		thesisSearchService.addThesisListIndex(list);
	}
}
