package com.spin.main.restApicontroller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spin.main.model.Postings;
import com.spin.main.model.usermaster;
import com.spin.main.responsemodel.Errorcodes;
import com.spin.main.responsemodel.PostingWrapper;
import com.spin.main.responsemodel.PostingsRequestWrapper;
import com.spin.main.service.PostingService;
import com.spin.main.storage.StorageService;

@RestController
@RequestMapping("/api")
public class PostingApiController {

	@Autowired
	private PostingService ps;
	@Autowired
	private StorageService storageservice;

// private static final String UPLOAD_DIRECTORY ="/images";
	private String location = "F:/SpinReporterUploads";
/*
	@RequestMapping(value = "/PostAPI/PostingData1", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostingWrapper> getPostings(@RequestParam("file") MultipartFile file,

			@RequestParam Integer postingtypeid, @RequestParam String posttitle, @RequestParam String postdescription,

			@RequestParam Integer categoryid, @RequestParam Integer countryid, @RequestParam Integer stateid,

			@RequestParam Integer cityid, @RequestParam Integer languageid, @RequestParam Date dateofposting,

			@RequestParam Integer postprice, @RequestParam Integer isactive, @RequestParam String currentsatus,

			@RequestParam Integer expiredby, @RequestParam Integer lastmodifiedby, @RequestParam Date lastmodifiedon,

			@RequestParam usermaster usermasterid) throws ParseException, Exception {

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
		bp.setIsactive(isactive); // bp.setExpirydate(expirydate);
		bp.setCurrentsatus(currentsatus);
		bp.setExpiredby(expiredby);
		bp.setLastmodifiedby(lastmodifiedby);
		bp.setLastmodifiedon(lastmodifiedon);
		bp.setUsermaster(usermasterid);
		File file2 = new File(location + File.separator + bp.getPosttitle());
		bp.setPreview(file2.getCanonicalPath());

		if (!(bp.getPreview().isEmpty() && bp.getCityid() == null && bp.getCountryid() == null
				&& bp.getDateofposting() == null && bp.getIsactive() == null && bp.getStateid() == null
				&& bp.getLanguageid() == null && bp.getExpiredby() == null && bp.getPostdescription().isEmpty()
				&& bp.getExpirydate() == null && bp.getPostingtypeid() == null && bp.getPostprice() == null
				&& bp.getPostprice() == null && bp.getCategoryid() == null)) {

			storageservice.store(file);
			ps.savePostings(bp);
			Errorcodes info = new Errorcodes();
			PostingWrapper r = new PostingWrapper();
			info.setErrorCode(1);
			info.setErrorMessage("post uploading success.."); //
			info.setCurrentId(Signup.getId()); // info.setCurrentId(bp.getPostid());
			r.setInfo(info);
			return new ResponseEntity<PostingWrapper>(r, HttpStatus.OK);

		} else {
			Errorcodes info = new Errorcodes();
			PostingWrapper r = new PostingWrapper();
			info.setErrorCode(0);
			info.setErrorMessage("post uploading failed.."); //
			info.setCurrentId(Signup.getId()); // info.setCurrentId(bp.getPostid());
			r.setInfo(info);
			return new ResponseEntity<PostingWrapper>(r, HttpStatus.BAD_REQUEST);

		}

	}*/

	@PostMapping(value = "/PostAPI/PostingData1")
	public ResponseEntity<PostingWrapper> postData(@ModelAttribute Postings postings,
			@RequestParam(name = "postingtypeid") Integer postingtypeid,
			@RequestParam(name = "posttitle") String posttitle,
			@RequestParam(name = "postdescription") String postdescription,
			@RequestParam(name = "categoryid") Integer categoryid, @RequestParam(name = "countryid") Integer countryid,
			@RequestParam(name = "stateid") Integer stateid, @RequestParam(name = "languageid") Integer languageid,
			@RequestParam(name = "dateofposting") Date dateofposting,
			@RequestParam(name = "postprice") Integer postprice, @RequestParam(name = "file") MultipartFile files,
			usermaster usermaster) throws Exception, IOException {

		System.out.println(postings);

		if (!(files.isEmpty()&&postingtypeid==null&&posttitle==null&&postdescription==null&&categoryid==null&&countryid==null&&stateid==null&&languageid==null&&dateofposting==null&&postprice==null)) {
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

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			LocalDate localdate = LocalDate.now();
			Date datesql = java.sql.Date.valueOf(localdate);

			System.out.println("this is local date formate to sql" + timestamp.getTime());

			String dateAndFileName = null;
	
			Integer postingtypeid2 = postings.getPostingtypeid();

// 2 is Videos
			if (2 == postingtypeid2) {
				dateAndFileName = location + "posting" + timestamp.getTime() + ".mp4";
			}

// 1 is ARTICLES
			if (1 == postingtypeid2) {
				dateAndFileName = location + "posting" + timestamp.getTime() + ".pdf";
			}

// 3 is IMAGES
			if (3 == postingtypeid2) {
				dateAndFileName = location + "posting" + timestamp.getTime() + ".jpg";
			}

// 4 is TALKS
			if (4 == postingtypeid2) {
				dateAndFileName = location + "posting" + timestamp.getTime() + ".mp3";
			}

			try {
// read and write the file to the selected location-
				

					byte[] bytes = files.getBytes();
					
						Path path = Paths.get(dateAndFileName);
						Files.write(path, bytes);
				


				}

			 catch (IOException e) {
				e.printStackTrace();
			}

			postings.setDateofposting(datesql);
			postings.setPreview(dateAndFileName);
			
			System.out.println(postings);
			
			ps.savePostings(postings);

				Errorcodes info = new Errorcodes();
				PostingWrapper r = new PostingWrapper();
				info.setErrorCode(1);
				info.setErrorMessage("post uploading success.."); //
/*				info.setCurrentId(Signup.getId()); 
*/				r.setInfo(info);
				return new ResponseEntity<PostingWrapper>(r, HttpStatus.OK);

			} else {
				Errorcodes info = new Errorcodes();
				PostingWrapper r = new PostingWrapper();
				info.setErrorCode(0);
				info.setErrorMessage("post uploading failed.."); //
/*				info.setCurrentId(Signup.getId()); // info.setCurrentId(bp.getPostid());
*/				r.setInfo(info);
				return new ResponseEntity<PostingWrapper>(r, HttpStatus.BAD_REQUEST);

			}
		}

	

	@PostMapping(value = "/userGallaryApi/userGallary", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostingsRequestWrapper> findByPostingUserData(@RequestBody Postings postings)
			throws IOException {

		if (postings.getUsermaster().getUserid() == null) {
			System.out.println("this is if part");
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("userid empty please enter /userGallaryApi/userGallaryuserid");
			PostingsRequestWrapper postingsRequestWrapper = new PostingsRequestWrapper();
			postingsRequestWrapper.setInfo(info);
			return new ResponseEntity<PostingsRequestWrapper>(postingsRequestWrapper, HttpStatus.BAD_REQUEST);

		} else {

			List<Postings> allImages = ps.findByPostingImages(postings.getUsermaster().getUserid(), 3);
			List<Postings> allVideos = ps.findByPostingVideos(postings.getUsermaster().getUserid(), 2);
			List<Postings> allBlogs = ps.findByPostingBlogs(postings.getUsermaster().getUserid(), 1);
			List<Postings> allTalks = ps.findByPostingTalks(postings.getUsermaster().getUserid(), 4);
			List<Postings> list = new ArrayList<>();
			list.addAll(allImages);
			list.addAll(allVideos);
			list.addAll(allBlogs);
			list.addAll(allTalks);

			if (!(list.isEmpty())) {
				Errorcodes info = new Errorcodes();

				info.setErrorCode(1);
				info.setErrorMessage("userIdImages has loaded");
				PostingsRequestWrapper postingsRequestWrapper = new PostingsRequestWrapper();
				postingsRequestWrapper.setInfo(info);
				postingsRequestWrapper.setPostings(list);
				/*
				 * r.setPostings(allVideos); r.setPostings(allBlogs); r.setPostings(allTalks);
				 */

				return new ResponseEntity<PostingsRequestWrapper>(postingsRequestWrapper, HttpStatus.OK);

			} else {
				System.out.println("this is else part");
				Errorcodes info = new Errorcodes();
				info.setErrorCode(0);
				info.setErrorMessage("userIdImages has empty loaded");
				PostingsRequestWrapper postingsRequestWrapper = new PostingsRequestWrapper();
				postingsRequestWrapper.setInfo(info);
				return new ResponseEntity<PostingsRequestWrapper>(postingsRequestWrapper, HttpStatus.BAD_REQUEST);
			}
		}

	}
}