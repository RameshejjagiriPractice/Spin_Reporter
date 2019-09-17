package com.spin.main.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spin.main.model.Postings;
import com.spin.main.repository.PostingRepository;
@Service
public class FilterBetweenDatesService {
	@Autowired
	PostingRepository postRep;
	
public	List<Postings>filterPostsBetweenDates(Date from,Date to){
		
		return postRep.getAllBetweenDates(from, to);
		
	}
	
	
	
	
}
