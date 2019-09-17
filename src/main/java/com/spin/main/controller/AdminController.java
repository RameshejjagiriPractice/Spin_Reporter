package com.spin.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spin.main.model.Postings;
import com.spin.main.model.categorymaster;
import com.spin.main.model.countrymaster;
import com.spin.main.model.languagemaster;
import com.spin.main.model.statemaster;
import com.spin.main.model.subcategorymaster;
import com.spin.main.service.AdminService;
import com.spin.main.service.PostingService;
import com.spin.main.service.UsermasterService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UsermasterService userService;

	@Autowired
	private PostingService postingService;

	// ---------------------------------------------Admin_Open--------------------------------------------------

	@GetMapping("/adminpage")
	public String showAdminPage(Model model) {

		long allUserCount = userService.allUserCount();
		model.addAttribute("allUserCount", allUserCount);

		long allImageCount = postingService.allImageCount();
		model.addAttribute("allImageCount", allImageCount);

		long allVideosCount = postingService.allVideosCount();
		model.addAttribute("allVideosCount", allVideosCount);

		long allArticlesCount = postingService.allArticlesCount();
		model.addAttribute("allArticlesCount", allArticlesCount);

		long allTalksCount = postingService.allTalksCount();
		model.addAttribute("allTalksCount", allTalksCount);

		return "AdminIndex";
	}

	@GetMapping("/adminpageApi")
	public ResponseEntity<Object> revenueData(@ModelAttribute Postings postings, Model map) {


		long allImageCount = postingService.allImageCount();
		long allVideosCount = postingService.allVideosCount();
		long allArticlesCount = postingService.allArticlesCount();
		long allTalksCount = postingService.allTalksCount();

		ArrayList<Object> revenuData = new ArrayList<>();
		revenuData.add(allImageCount);//index[0]
		revenuData.add(allVideosCount);//index[1]
		revenuData.add(allArticlesCount);//index[2]
		revenuData.add(allTalksCount);//index[3]

		return new ResponseEntity<Object>(revenuData, HttpStatus.OK);

	}

	@GetMapping("/country")
	public String cuntry(Model model) {
		model.addAttribute("countries", new countrymaster());
		List<countrymaster> countries = userService.getCountry();
		model.addAttribute("listcountries", countries);
		return "country";
	}

	@GetMapping("/add_country")
	public String add_country(Model model) {
		model.addAttribute("countries", new countrymaster());
		return "add_country";
	}

	@PostMapping("/savecountry")
	public String det(Model model, countrymaster countries) {
		adminService.createCountry(countries);
		List<countrymaster> countrie = userService.getCountry();
		model.addAttribute("listcountries", countrie);
		return "country";
	}

	// ---------------------------------------------statemaster--------------------------------------------------

	@GetMapping("/state")
	public String states(Model model) {
		model.addAttribute("values", new statemaster());
		List<statemaster> values = userService.getState();
		model.addAttribute("liststates", values);
		return "state";
	}

	@GetMapping("/add_state")
	public String addState(Model model) {
		List<countrymaster> c = userService.getCountry();

		model.addAttribute("values", new statemaster());
		model.addAttribute("countries", c);
		return "add_state";
	}

	@PostMapping("/saveState")
	public String details(Model model, statemaster values) {
		adminService.createState(values);
		model.addAttribute("liststates", userService.getState());
		return "state";
	}

	// ------------------------------------------------subcategory-----------------------------------------

	@GetMapping("/subcategories")
	public String subcategory(Model model) {
		model.addAttribute("subcat", new subcategorymaster());
		List<subcategorymaster> subcat = userService.getsubCategory();
		model.addAttribute("listsub", subcat);
		return "sub_categories";
	}

	@GetMapping("/add_subcategories")
	public String addsubcat(Model model) {
		model.addAttribute("subcat", new subcategorymaster());
		return "add_sub_category";
	}

	@PostMapping("/savesubcategories")
	public String details(Model model, subcategorymaster subcat) {
		// model.addAttribute("subcat", new subcategorymaster());
		adminService.createSubcat(subcat);
		List<subcategorymaster> subcats = userService.getsubCategory();
		model.addAttribute("listsub", subcats);
		return "sub_categories";
	}

	// --------------------------------------categories--------------------------------------

	@RequestMapping("/categories")
	public String showViewCategoryPage(Model model) {
		List<categorymaster> listCategories = userService.getCategory();
		model.addAttribute("listCategories", listCategories);
		return "categories";
	}

	@RequestMapping("/add_categories")
	public String addCategories(@ModelAttribute categorymaster categories, Model model) {
		model.addAttribute("listCategories", categories);
		return "add_category";
	}

	@PostMapping("/savecategory")
	public String details(Model model, categorymaster listCategories)

	{
		adminService.createCategory(listCategories);
		model.addAttribute("listCategories", userService.getCategory());
		return "categories";
	}

	/// ---------------------------------languagemaster----------------------------------

	@RequestMapping("/languages")
	public String viewLanguagesPage(Model model) {
		model.addAttribute("listlanguages", new languagemaster());
		List<languagemaster> listlanguages = userService.getLanguage();
		model.addAttribute("listLanguages", listlanguages);
		return "languages";

	}

	@RequestMapping("/add_language")
	public String AddLanguages(Model model, languagemaster language) {
		// List<Languages> listlanguages= service.getLanguages();
		language.setIsactive(1);
		model.addAttribute("listlanguages", new languagemaster());
		// model.addAttribute("Languages", language);

		return "add_language";
	}

	@PostMapping("/savelanguage")
	public String createLan(Model model, languagemaster listlanguages) {
		adminService.createLanguage(listlanguages);
		model.addAttribute("listLanguages", userService.getLanguage());
		return "languages";
	}

}
