package com.spin.main.controller;
//sandeepK


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spin.main.dao.LoginDao;
import com.spin.main.model.Postings;
import com.spin.main.model.usermaster;
import com.spin.main.service.EmailService;
import com.spin.main.service.HomePageService;
import com.spin.main.service.PostingService;
import com.spin.main.service.UsermasterService;
import com.spin.main.storage.StorageService;

@Controller
public class LoginController {

	private static Integer Id=null;
	@Autowired
	private LoginDao login;
	@Autowired
	private UsermasterService userService;

	@Autowired
	private StorageService storageService;

	@Autowired
	private EmailService emailService;

	private static Integer userid = null;

	@Autowired
	private PostingService postingService;
	
	@Autowired
	private PostingController postingController;
	
	@Autowired
	private HomePageService homepageService;


	
	
	//private final String globalPath="http://14.98.166.66/SpinReporterUploads/";
	private final String globalPath="http://localhost:9092/files/";

	@GetMapping("/login")
	public String getLogin(Model m) {
		m.addAttribute("usermaster", new usermaster());
		return "login";
	}

	
	@GetMapping("/index")
	public String getIndex(Model model) {
		 model.addAttribute("usermaster", new usermaster());
		//	model.addAttribute("names", signup1.getUsername());
		model.addAttribute("id", Id);

		return "index";
	}

	@SuppressWarnings("unused")
	@PostMapping("/loginValidate")
	public String validate(Model model, usermaster user,Postings postings) {
		
		try {

			usermaster signup1 = login.validateUser(user);
			Id = signup1.getUserid();

			// list.stream().forEach(System.out::println);
			postingController.setUserMasterPrimaryKey(signup1);
			System.out.println(signup1.getUsername());
			System.out.println(Id);

			model.addAttribute("log", new usermaster());

			model.addAttribute("names", signup1.getUsername());

			model.addAttribute("id", Id);
			
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
			return "index";

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			return "login";
		}


		/*
		 * if (!(null==signup1)) {
		 * 
		 * // list.stream().forEach(System.out::println);
		 * postingController.setUserMasterPrimaryKey(signup1);
		 * System.out.println(signup1.getUsername()); System.out.println(Id);
		 * 
		 * model.addAttribute("log", new usermaster());
		 * 
		 * model.addAttribute("names", signup1.getUsername());
		 * 
		 * model.addAttribute("id", Id);
		 * 
		 * List<Postings> articles = homepageService.getArticles(postings);
		 * model.addAttribute("article",articles);
		 * 
		 * List<Postings> videos = homepageService.getVideos(postings);
		 * 
		 * model.addAttribute("video",videos);
		 * 
		 * List<Postings> images = homepageService.getImages(postings);
		 * model.addAttribute("image",images);
		 * 
		 * List<Postings> audios = homepageService.getAudios(postings);
		 * model.addAttribute("audio",audios);
		 * 
		 * model.addAttribute("globalPath", globalPath); model.addAttribute("yash",
		 * "#");
		 * 
		 * 
		 * return "index";
		 */

		/*
		 * } else {
		 * 
		 * // model.addAttribute("log", new usermaster()); model.addAttribute("emailid",
		 * signup1.getEmailid()); model.addAttribute("usermaster", new usermaster());
		 * 
		 * return "login";
		 * 
		 * }
		 */

	}

	@GetMapping("/{Id}")
	public String userDetails(Model model, @PathVariable Integer Id) throws IOException {
		usermaster s = userService.getUserByID(Id);

		

		
		Postings p=new Postings();
		model.addAttribute("name", s.getUsername());
		model.addAttribute("email", s.getEmailid());
		model.addAttribute("mobileNumber", s.getMobilenumber());
		model.addAttribute("fileName",s.getUserimage());
		model.addAttribute("globalPath",globalPath);
		model.addAttribute("postingtypeid",p.getPostingtypeid());
		// model.addAttribute("location", s.getLocation());

		// ---------------------------------------Ande_Ranjith------------User_Data_fecting--------------------------------------------

		List<Postings> findByUserVideos = postingService.findByUserVideos(Id);
		for (Postings postings : findByUserVideos) {
			System.out.println(postings.getPreview());
		}

		// globalPath
		model.addAttribute("globalPath", globalPath);
		model.addAttribute("yash", "#");


		// findByUserArticles
		List<Postings> findByUserArticles = postingService.findByUserArticles(Id);
		model.addAttribute("findByUserArticles", findByUserArticles);

		// findByUserVideos
		model.addAttribute("findByUserVideos", findByUserVideos);

		// findByUserImages
		List<Postings> findByUserImages = postingService.findByUserImages(Id);
		model.addAttribute("findByUserImages", findByUserImages);

		// findByUserTalks
		List<Postings> findByUserTalks = postingService.findByUserTalks(Id);
		model.addAttribute("findByUserTalks", findByUserTalks);
		
		// ---------------------------------------Ande_Ranjith------------User_Data_fecting--------------------------------------------


		return "pro";

	}
	
	

	/*@GetMapping("/getvideo/{id}")
	public String getPostingId(@PathVariable("id") Integer posting_id, Model model) {

		//getByPosting
			Postings posting = postingService.getByPosting(posting_id);

			System.out.println("-----------"+posting.getPreview());
			
			
			model.addAttribute("globalPath", globalPath);

			model.addAttribute("posting", posting);
		

		return "profile";

	}*/


	@GetMapping("/forgot_password")
	public String forgotPassword(Model model) {

		model.addAttribute("usermaster", new usermaster());

		return "forgot_password";

	}

	@GetMapping("/reset_password")
	public String resetPassword(Model model) {
		model.addAttribute("usermaster", new usermaster());

		return "reset_password";

	}

	@PostMapping("/sentMail")
	public String forgotPassword(Model model, @RequestParam("emailid") String emailid) {

		if (null != userService.findBySpringReporterUserName(emailid)) {
			usermaster userData = userService.findBySpringReporterUserName(emailid);

			userid = userData.getUserid();
			emailService.sendEmailWeb(userData);
			System.out.println("Email Send : Controller");

			model.addAttribute("usermaster", new usermaster());

			return "login";

		} else {

			model.addAttribute("usermaster", new usermaster());

			return "redirect:/forgot_password";
		}

	}

	@PostMapping("/reEnterPassword")
	private String validatePassword(@ModelAttribute usermaster usermaster, ModelMap map) {

		System.out.println(usermaster + "this  is userid" + userid);

		if (usermaster.getPword().equals(usermaster.getConfirmpword())) {

			System.out.println("user enter password:" + usermaster.getPword().equals(usermaster.getConfirmpword()));
			System.out.println("=====================this one getuser id:" + userid);
			userService.updatePassword(usermaster.getPword(), userid);

			return "login";

		} else {

			return "reset_password";

		}

	}

}
