package com.spin.main.restApicontroller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

//sandeepK
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spin.main.dao.LoginDao;
import com.spin.main.model.Postings;
import com.spin.main.model.usermaster;
import com.spin.main.responsemodel.Errorcodes;
import com.spin.main.responsemodel.PostingWrapper;
import com.spin.main.responsemodel.RequestWrapper;
import com.spin.main.service.PostingService;
import com.spin.main.service.UsermasterService;

@RestController
@RequestMapping("/api")
public class LoginApiController {

	@Autowired
	private LoginDao login;

	@Autowired
	private UsermasterService userService;
	
	@Autowired
	private PostingService postingService;

	private Integer Id;

	@RequestMapping(value = "/LoginAPI/Login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<RequestWrapper> Login(@RequestBody usermaster user) {
		usermaster signup1 = login.validateUser(user);
		// Id=signup1.getId();

		Id = user.getUserid();

		if (null != signup1) {
			RequestWrapper r = new RequestWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("success");
			r.setInfo(info);
			r.setData(signup1);

			// return Info;
			return new ResponseEntity<RequestWrapper>(r, HttpStatus.OK);

		} else {
			RequestWrapper r = new RequestWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("failed to login");
			r.setInfo(info);
			// return Info;
			return new ResponseEntity<RequestWrapper>(r, HttpStatus.OK);

		}

	}

	@GetMapping("/UserDetails/{Id}")
	public ResponseEntity<RequestWrapper> userDetails(@PathVariable Integer Id) {

		usermaster s = userService.getUserByID(Id);
		if (null != s) {
			RequestWrapper r = new RequestWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("success");
			info.setCurrentId(Id);
			r.setInfo(info);
			r.setData(s);

			// return Info;
			return new ResponseEntity<RequestWrapper>(r, HttpStatus.OK);

		} else {
			RequestWrapper r = new RequestWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("failed to load data");
			r.setInfo(info);
			// return Info;
			return new ResponseEntity<RequestWrapper>(r, HttpStatus.OK);

		}

	}
	
	@RequestMapping(value = "/GetAPI/GetData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody

	public List<usermaster> getdata(usermaster user) {

		return userService.getUser();

	}
	
	private String location = "F://SpinReporterUploads";

	@RequestMapping(value = "/PostAPI/PostingData", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostingWrapper> getPostings(@RequestParam("file") MultipartFile file,
			@RequestParam Integer postingtypeid, @RequestParam String posttitle, @RequestParam String postdescription,
			@RequestParam Integer categoryid, @RequestParam Integer countryid, @RequestParam Integer stateid,
			@RequestParam Integer cityid, @RequestParam Integer languageid, @RequestParam Date dateofposting,
			@RequestParam Integer postprice, @RequestParam Integer isactive, @RequestParam String currentsatus,
			@RequestParam Integer expiredby, @RequestParam Integer lastmodifiedby, @RequestParam Date lastmodifiedon) throws ParseException, Exception {

		Postings bp = new Postings();
		bp.setPostingtypeid(postingtypeid);
		bp.setPosttitle(posttitle);
		bp.setPostdescription(postdescription);
		bp.setCategoryid(categoryid);
		bp.setCountryid(countryid);
		bp.setStateid(stateid);
		bp.setCityid(cityid);
		bp.setLanguageid(languageid);
		bp.setDateofposting(dateofposting);
		bp.setPostprice(postprice);
		bp.setIsactive(isactive);
		// bp.setExpirydate(expirydate);
		bp.setCurrentsatus(currentsatus);
		bp.setExpiredby(expiredby);
		bp.setLastmodifiedby(lastmodifiedby);
		bp.setLastmodifiedon(lastmodifiedon);
		
		usermaster userByID = userService.getUserByID(Id);
		bp.setUsermaster(userByID);
		File file2 = new File(location + File.separator + bp.getPosttitle());
		bp.setPreview(file2.getCanonicalPath());
		BufferedOutputStream stream = null;

		if (!(bp.getPreview().isEmpty() && bp.getCityid() == null && bp.getCountryid() == null
				&& bp.getDateofposting() == null && bp.getIsactive() == null && bp.getStateid() == null
				&& bp.getLanguageid() == null && bp.getExpiredby() == null && bp.getPostdescription().isEmpty()
				&& bp.getExpirydate() == null && bp.getPostingtypeid() == null && bp.getPostprice() == null
				&& bp.getPostprice() == null && bp.getCategoryid() == null)) {

			//storageservice.store(file);
			System.out.println(file2.getCanonicalPath());
			 byte[] bytes = file.getBytes();
			  
				
			  stream = new BufferedOutputStream(new
			  FileOutputStream(file2)); stream.write(bytes); stream.flush();
			  stream.close();
			postingService.savePostings(bp);
			Errorcodes info = new Errorcodes();
			PostingWrapper r = new PostingWrapper();
			info.setErrorCode(1);
			info.setErrorMessage("post uploading success..");
			// info.setCurrentId(Signup.getId());
			// info.setCurrentId(bp.getPostid());
			r.setInfo(info);
			return new ResponseEntity<PostingWrapper>(r, HttpStatus.OK);

		} else {
			Errorcodes info = new Errorcodes();
			PostingWrapper r = new PostingWrapper();
			info.setErrorCode(0);
			info.setErrorMessage("post uploading failed..");
			// info.setCurrentId(Signup.getId());
			// info.setCurrentId(bp.getPostid());
			r.setInfo(info);
			return new ResponseEntity<PostingWrapper>(r, HttpStatus.BAD_REQUEST);

		}

	}
	
	@GetMapping("/U/{postingtypeid}")
	public ResponseEntity<PostingWrapper> useDetails(@PathVariable Integer postingtypeid) {

		List<Postings> p=postingService.getCountryById(postingtypeid);
		if (null != p) {
			PostingWrapper r = new PostingWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("success");
			//info.setCurrentId(Id);
			r.setInfo(info);
			r.setData(p);
		

			// return Info;
			return new ResponseEntity<PostingWrapper>(r, HttpStatus.OK);

		} else {
			PostingWrapper r = new PostingWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("failed to load data");
			r.setInfo(info);
			// return Info;
			return new ResponseEntity<PostingWrapper>(r, HttpStatus.OK);

		}

	}
	

}
