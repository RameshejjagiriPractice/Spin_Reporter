package com.spin.main.controller;
//sandeep kathoju

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spin.main.model.Postings;
import com.spin.main.service.HomePageService;
import com.spin.main.service.PostingService;

@Controller
public class DetailPageController {

	@Autowired
	private PostingService postingService;

	private String globalPath = "http://localhost:9092/files/";
	// private final String globalPath="http://14.98.166.66/SpinReporterUploads/";

	@Autowired
	private HomePageService homepageService;

	@GetMapping("/detailedPage/{postingtypeid}")
	public String getPage(@PathVariable("postingtypeid") Integer postingtypeid, Model model, Postings postings) {
		System.out.println(postingtypeid);

		Postings p = postingService.getPostingByid(postingtypeid);
		List<Postings> videos = homepageService.getVideos(postings);

		model.addAttribute("video", videos);

		// List<Postings> countryById = postingService.getCountryById(postingtypeid);

		model.addAttribute("posttitle", p.getPosttitle());
		model.addAttribute("dateofposting", p.getDateofposting());
		model.addAttribute("postdescription", p.getPostdescription());
		model.addAttribute("path", globalPath);
		model.addAttribute("pathName", p.getPreview());
		model.addAttribute("thumnail", p.getThumnail());
		System.out.println("path" + p.getPreview());

		System.out.println("title" + p.getPosttitle());

		return "detail";
	}
}
