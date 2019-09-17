package com.spin.main.restApicontroller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spin.main.model.UserOtp;
import com.spin.main.model.usermaster;
import com.spin.main.responsemodel.Errorcodes;
import com.spin.main.responsemodel.RequestWrapper;
import com.spin.main.service.EmailService;
import com.spin.main.service.UserOtpService;
import com.spin.main.service.UsermasterService;

@RestController
@RequestMapping("/api")
public class UserOtpController {

	
@Autowired
private UsermasterService userService;
	@Autowired
	private EmailService emailService;

	@Autowired
	private UserOtpService userOtpService;

	private String verficationCode;
	private static Integer userid;

	@PostMapping(value = "/ResetAPI/forgotPassword")
	private ResponseEntity<RequestWrapper> Login(@RequestBody usermaster login, ModelMap map) {

		System.out.println(login.getEmailid());

		if (null != userService.findBySpringReporterUserName(login.getEmailid())) {
			usermaster login1 = userService.findBySpringReporterUserName(login.getEmailid());

			userid = login1.getUserid();

			String numbers = "0123456789";

			Random rndm_method = new Random();

			int len = 4;
			char[] otp = new char[len];

			for (int i = 0; i < len; i++) {
				// Use of charAt() method : to get character value
				// Use of nextInt() as it is scanning the value as int
				otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
			}
			verficationCode = "" + otp[0] + otp[1] + otp[2] + otp[3];

			System.out.println("verification b4 email:-----" + verficationCode);

			emailService.sendEmail(login1, verficationCode);
			System.out.println("Email Send : Controller");

			if (!(userOtpService.exitUserOtp(userid) == null)) {
				UserOtp userOtpData = userOtpService.exitUserOtp(userid);

				Integer otpId = userOtpData.getOtpid();
				userOtpService.updateExictUserOtp(new Date(), 1, verficationCode, otpId);

			} else {

				UserOtp uo = new UserOtp();
				uo.setOtpcode(verficationCode);
				uo.setUserid(userid);
				uo.setIsactive(1);
				uo.setCreatedon(new Date());
				userOtpService.saveUserOtp(uo);
			}

			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("verification code sent to your mail");
			RequestWrapper r = new RequestWrapper();
			r.setInfo(info);

			return new ResponseEntity<RequestWrapper>(r, HttpStatus.OK);

		} else {
			System.out.println("this is else part");
			map.addAttribute("login", new usermaster());
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("email does not exist");
			RequestWrapper r = new RequestWrapper();
			r.setInfo(info);
			return new ResponseEntity<RequestWrapper>(r, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/ResetAPI//validateOtp")
	private ResponseEntity<RequestWrapper> validatePin(@RequestBody UserOtp userOtp, ModelMap map) {

	
		 String otp = userOtp.getOtpcode();
		//System.out.println("user otp:" + userOtp.getUserid());
		UserOtp data = userOtpService.getUserOtp(userid, 1);

		//System.out.println("otp table data:" + data);
		String verifiOtp = data.getOtpcode().toString();
		//System.out.println("this is database verfication code " + data.getOtpcode());
		// System.out.println("system generated otp:" + verficationCode);
		if (verifiOtp.equals(otp)) {

			System.out.println("validate otp:" + verifiOtp.equals(otp));

			userOtpService.updateUserOtp(0, new Date(), data.getOtpid());

			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("verified");
			RequestWrapper r = new RequestWrapper();
			r.setInfo(info);

			return new ResponseEntity<RequestWrapper>(r, HttpStatus.OK);

		} else {

			map.addAttribute("login", new usermaster());

			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("verification code incorrect");
			RequestWrapper r = new RequestWrapper();
			r.setInfo(info);

			return new ResponseEntity<RequestWrapper>(r, HttpStatus.BAD_REQUEST);
		}

	}

	
	
	@PostMapping("/ResetAPI/reEnterPassword")
	private ResponseEntity<RequestWrapper> validatePassword(@RequestBody usermaster login, ModelMap map) {

		if (login.getPword().equals(login.getConfirmpword())) {

			//System.out.println("user enter password:" + login.getPword().equals(login.getRpword()));
			//System.out.println("=====================this one getuser id:" + userid);
			userService.updatePassword(login.getPword(), userid);
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("password updated");
			RequestWrapper r = new RequestWrapper();
			r.setInfo(info);

			return new ResponseEntity<RequestWrapper>(r, HttpStatus.OK);


		} else {

			//System.out.println("validatePassword failed");

			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage(" Password update failed");
			RequestWrapper r = new RequestWrapper();
			r.setInfo(info);

			return new ResponseEntity<RequestWrapper>(r, HttpStatus.BAD_REQUEST);

		}

	}
}
