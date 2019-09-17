package com.spin.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spin.main.model.Postings;
import com.spin.main.repository.PostingRepository;

@Service
public class HomePageService {
	
	@Autowired
	private PostingRepository postingsRepository;
	
	public List<Postings> getArticles(Postings postings) {
		List<Postings> list = new ArrayList<>();
		postingsRepository.findByArticles(postings).forEach(list::add);
		return list;

	}
	
	public List<Postings> getVideos(Postings postings) {
		List<Postings> list = new ArrayList<>();
		postingsRepository.findByVideos(postings).forEach(list::add);
		return list;

	}
	
	public List<Postings> getImages(Postings postings) {
		List<Postings> list = new ArrayList<>();
		postingsRepository.findByImages(postings).forEach(list::add);
		return list;

	}
	
	public List<Postings> getAudios(Postings postings) {
		List<Postings> list = new ArrayList<>();
		postingsRepository.findByAudios(postings).forEach(list::add);
		return list;

	}

}
