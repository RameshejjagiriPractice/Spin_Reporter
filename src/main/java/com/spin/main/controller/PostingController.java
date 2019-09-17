package com.spin.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spin.main.model.Postings;
import com.spin.main.model.statemaster;
import com.spin.main.model.usermaster;
import com.spin.main.responsemodel.Errorcodes;
import com.spin.main.responsemodel.StateWrapper;
import com.spin.main.service.PostingService;
import com.spin.main.service.UsermasterService;
import com.spin.main.storage.StorageService;

@Controller
public class PostingController {

	@Autowired
	private PostingService postingservice;

	@Autowired
	private UsermasterService userService;

	@Autowired
	private StorageService storageservice;

	@Autowired
	private UsermasterService usermasterserv;

	private String location = "F:/SpinReporterUploads/";

	@GetMapping("/GetCountryById/selectedCountry")
	public ResponseEntity<StateWrapper> CountryById(@ModelAttribute Postings postings, Model map) {

		List<statemaster> states = usermasterserv.getCountryById(postings.getCountryid());
		if (null != states) {
			StateWrapper r = new StateWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("success");
            // info.setCurrentId(Id);
			r.setInfo(info);
			r.setStates(states);
			return new ResponseEntity<StateWrapper>(r, HttpStatus.OK);

		} else {
			StateWrapper r = new StateWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("failed to load data");
			r.setInfo(info);
// return Info;
			return new ResponseEntity<StateWrapper>(r, HttpStatus.OK);

		}
	}

	@GetMapping("/showpostingpage")
	public String showblog(ModelMap map) {
		map.addAttribute("postings", new Postings());
		map.addAttribute("country", usermasterserv.getCountry());
		map.addAttribute("state", usermasterserv.getState());
		map.addAttribute("language", usermasterserv.getLanguage());
		map.addAttribute("category", usermasterserv.getCategory());
		map.addAttribute("subcategory", usermasterserv.getsubCategory());

		return "post";
	}

	public static usermaster usermaster = null;

	usermaster setUserMasterPrimaryKey(usermaster userData) {

		return usermaster = userData;
	}

	@PostMapping("/insertposting")
	public String insertposting(@ModelAttribute Postings postings,
			@RequestParam(name = "postingtypeid") Integer postingtypeid,
			@RequestParam(name = "posttitle") String posttitle,
			@RequestParam(name = "postdescription") String postdescription,
			@RequestParam(name = "categoryid") Integer categoryid, @RequestParam(name = "countryid") Integer countryid,
			@RequestParam(name = "stateid") Integer stateid, @RequestParam(name = "languageid") Integer languageid,
			@RequestParam(name = "dateofposting") Date dateofposting,
			@RequestParam(name = "postprice") Integer postprice, @RequestParam(name = "file") MultipartFile[] files,
			ModelMap map) throws Exception, IOException {

		// usermaster userImage = userService.getUserByID(usermaster.getUserid());
		// System.out.println("==========????" + userImage.getUserimage());
		// map.addAttribute("userImage", userImage.getUserimage());
		System.out.println("this is file length" + files.length);

		System.out.println(postings);
		map.addAttribute("postings", new Postings());

		if (files.length == 2) {
			postings.setPostingtypeid(postingtypeid);
			postings.setPosttitle(posttitle);
			postings.setPostdescription(postdescription);
			postings.setCategoryid(categoryid);
			postings.setCountryid(countryid);
			postings.setStateid(stateid);
			postings.setLanguageid(languageid);
			postings.setPostprice(postprice);
			postings.setIsactive(1);
			postings.setUsermaster(usermaster);
			/*
			 * postings.setExpirydate(expirydate); postings.setCurrentsatus(currentsatus);
			 * postings.setExpiredby(expiredby); postings.setLastmodifiedby(lastmodifiedby);
			 * postings.setLastmodifiedon(lastmodifiedon);
			 */

// SimpleDateFormat timeStamp = new SimpleDateFormat("yyyyMMddHHmmss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			LocalDate localdate = LocalDate.now();
			Date datesql = java.sql.Date.valueOf(localdate);

			System.out.println("this is local date formate to sql" + timestamp.getTime());

			String dateAndFileName = null;
			String dateAndthumnail = null;
			Integer postingtypeid2 = postings.getPostingtypeid();

// 2 is Videos
			if (2 == postingtypeid2) {
				dateAndFileName = location + "posting" + timestamp.getTime() + ".mp4";
				dateAndthumnail = location + "thumnail" + timestamp.getTime() + ".jpg";
			}

// 1 is ARTICLES
			if (1 == postingtypeid2) {
				dateAndFileName = location + "posting" + timestamp.getTime() + ".pdf";
				dateAndthumnail = location + "thumnail" + timestamp.getTime() + ".jpg";
			}

// 3 is IMAGES
			if (3 == postingtypeid2) {
				dateAndFileName = location + "posting" + timestamp.getTime() + ".jpg";
				dateAndthumnail = location + "thumnail" + timestamp.getTime() + ".jpg";
			}

// 4 is TALKS
			if (4 == postingtypeid2) {
				dateAndFileName = location + "posting" + timestamp.getTime() + ".mp3";
				dateAndthumnail = location + "thumnail" + timestamp.getTime() + ".jpg";
			}

			try {
// read and write the file to the selected location-
				for (int i = 0; i < files.length; i++) {
					MultipartFile file = files[i];

					byte[] bytes = file.getBytes();
					if (0 == i) {
						Path path = Paths.get(dateAndFileName);
						Files.write(path, bytes);
					}

					if (1 == i) {
						Path path = Paths.get(dateAndthumnail);
						Files.write(path, bytes);
					}

				}

				/*
				 * byte[] thumnailByte = thumnail.getBytes(); Path pathThumnailByte =
				 * Paths.get(location); Files.write(pathThumnailByte, thumnailByte);
				 */

			} catch (IOException e) {
				e.printStackTrace();
			}

			postings.setDateofposting(datesql);
			postings.setPreview(dateAndFileName);
			postings.setThumnail(dateAndthumnail);
			postingservice.savePostings(postings);
// service.saveVideo(video);
			/*
			 * File file2 = new File(location + File.separator + postings.getPosttitle());
			 * postings.setPreview(file2.getCanonicalPath().toString());
			 */

			return "redirect:showpostingpage";
		}
		return "redirect:showpostingpage";

	}
}
