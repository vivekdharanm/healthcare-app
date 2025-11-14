package com.healthcare_application.HealthCare.search.service;

import java.util.List;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import com.healthcare_application.HealthCare.search.model.DoctorIndex;



@Service
public class SearchService 
{


	private final ElasticsearchOperations elasticsearchOperations;


	public SearchService(ElasticsearchOperations elasticsearchOperations) 
	{
		this.elasticsearchOperations = elasticsearchOperations;
	}


	public List<DoctorIndex> searchDoctorsByName(String name) 
	{
		Criteria criteria = new Criteria("name").matches(name);
		Query query = new CriteriaQuery(criteria);
		return elasticsearchOperations.search(query, DoctorIndex.class).map(s -> s.getContent()).toList();
	}
}