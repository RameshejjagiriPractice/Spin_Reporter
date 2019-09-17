package com.spin.main.controller;
//sandeepK

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spin.main.model.usermaster;
import com.spin.main.repository.usermasterRepository;
import com.spin.main.service.UsermasterService;
import com.spin.main.storage.StorageService;

@Controller
public class RegistartonController {

	@Autowired
	private usermasterRepository userRepository;

	@Autowired
	private UsermasterService userService;

	@Autowired
	private StorageService storageService;
	
	private String location = "F://SpinReporterUploads";

	@GetMapping("/sign_up")
	public String showSignup(Model m) {
		m.addAttribute("usermaster", new usermaster());
		m.addAttribute("country", userService.getCountry());
		m.addAttribute("state", userService.getState());

		m.addAttribute("language", userService.getLanguage());

		return "sign_up";
	}

	// @RequestMapping(value="/insert", method = RequestMethod.POST)
	@PostMapping("/insert")
	public String insert(Model m,@ModelAttribute("user") @RequestBody usermaster user, @RequestParam("file") MultipartFile file)
			throws IOException {
		usermaster existingUser = userRepository.findByEmailidIgnoreCase(user.getEmailid());
		BufferedOutputStream stream = null;
		  

		if (existingUser != null) {

			return "sign_up";
		} else {
			m.addAttribute("usermaster", new usermaster());
			 File file2 = new File(location + "/" +user.getEmailid()+ ".jpg");

			user.setIsactive(1);
			user.setUsertypeid(2);
			user.setRegistredon(new Date());
			user.setUserimage(file2.getCanonicalPath());
			System.out.println(file2.getAbsolutePath());
			 byte[] bytes = file.getBytes();
			  
			
			  stream = new BufferedOutputStream(new
			  FileOutputStream(file2)); stream.write(bytes); stream.flush();
			  stream.close();
			
			userService.addUser(user);
			return "login";
		}

	}

}
