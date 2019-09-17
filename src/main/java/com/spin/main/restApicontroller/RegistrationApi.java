package com.spin.main.restApicontroller;

//sandeepK
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spin.main.model.usermaster;
import com.spin.main.repository.usermasterRepository;
import com.spin.main.responsemodel.Errorcodes;
import com.spin.main.responsemodel.RequestWrapper;
import com.spin.main.service.UsermasterService;

@RestController
@RequestMapping("/api")
public class RegistrationApi {

	/*
	 * @Autowired private StorageService storageService;
	 */

	@Autowired
	private UsermasterService usermasterService;

	@Autowired
	private usermasterRepository userRepository;

	private String location = "F://SpinReporterUploads";

	@SuppressWarnings("resource")
	@RequestMapping(value = "/RegistartionAPI/Signup", method = RequestMethod.POST)
	public ResponseEntity<RequestWrapper> adEmployee(@RequestBody usermaster signup, HttpServletRequest request)
			throws IOException {

		usermaster existingUser = userRepository.findByEmailidIgnoreCase(signup.getEmailid());

		if (existingUser != null) {

			Errorcodes info = new Errorcodes();
			RequestWrapper r = new RequestWrapper();
			info.setErrorCode(2);
			info.setErrorMessage("Email Already Exists");
			// info.setCurrentId(s.getId());
			r.setInfo(info);
			return new ResponseEntity<RequestWrapper>(r, HttpStatus.ALREADY_REPORTED);

		}

		else {

			byte[] btDataFile = Base64.decodeBase64(signup.getUserimage());
			File file2 = new File(location + File.separator + signup.getEmailid() + ".jpg");

			// signup.setLocation(file2.getCanonicalPath());
			signup.setUserimage(file2.getCanonicalPath());

			signup.setIsactive(1);
			signup.setUsertypeid(2);
			signup.setRegistredon(new Date());
			// signup.setCurentsatus);
			System.out.println(file2.getCanonicalPath());

			new FileOutputStream(file2).write(btDataFile);

			usermasterService.addUser(signup);

			Errorcodes info = new Errorcodes();
			RequestWrapper r = new RequestWrapper();
			info.setErrorCode(1);
			info.setErrorMessage("registration success");
			info.setCurrentId(signup.getUserid());
			r.setInfo(info);
			r.setData(signup);

			return new ResponseEntity<RequestWrapper>(r, HttpStatus.OK); 

		}
	}

	@RequestMapping(value = "/RegistartionAPI/emailAvailability", method = RequestMethod.POST)
	public ResponseEntity<RequestWrapper> email(@RequestBody usermaster user) {
		usermaster existingUser = userRepository.findByEmailidIgnoreCase(user.getEmailid());

		if (existingUser != null) {

			Errorcodes info = new Errorcodes();
			RequestWrapper r = new RequestWrapper();
			info.setErrorCode(1);
			info.setErrorMessage("Email Already Exists");
			/* info.setCurrentId(s.getId()); */
			r.setInfo(info);
			return new ResponseEntity<RequestWrapper>(r, HttpStatus.ALREADY_REPORTED);

		} else {

			Errorcodes info = new Errorcodes();
			RequestWrapper r = new RequestWrapper();
			info.setErrorCode(0);
			info.setErrorMessage("email not available");
			/* info.setCurrentId(s.getId()); */
			r.setInfo(info);
			return new ResponseEntity<RequestWrapper>(r, HttpStatus.OK);
		}

	}

}
