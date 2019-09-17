package com.spin.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spin.main.model.Postings;
import com.spin.main.repository.PostingRepository;

@Service
public class SearchBykeyWordService {
	@Autowired
	PostingRepository postRep;
	
	public List<Postings>searchByKeyWord(String serchTerm){

		
		return postRep.findBySearchTermNative(serchTerm);
	}

	
	
	
}
