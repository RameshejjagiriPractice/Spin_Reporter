package com.spin.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spin.main.model.Postings;
import com.spin.main.service.HomePageService;

@Controller
public class HomePageController {

	@Autowired
	private HomePageService homepageService;
	
	private final String globalPath="http://localhost:9092/files/";
	//private final String globalPath="http://14.98.166.66/SpinReporterUploads/";

	@GetMapping("/")
	public String showHome(Model model, Postings postings) {
		
		
		
		
		List<Postings> articles = homepageService.getArticles(postings);
		model.addAttribute("article",articles);
		
		List<Postings> videos = homepageService.getVideos(postings);
		
		model.addAttribute("video",videos);
		
		
		
		List<Postings> images = homepageService.getImages(postings);
		model.addAttribute("image",images);
		
		List<Postings> audios  = homepageService.getAudios(postings);
		model.addAttribute("audio",audios);
		
		model.addAttribute("globalPath", globalPath);
		model.addAttribute("yash", "#");
		return "home";
	}
	
	
	

	@GetMapping("/show")
	@ResponseBody
	private List<Postings> showpostings(Postings postings) {

		List<Postings> p = homepageService.getArticles(postings);
		return p;

	}

}
