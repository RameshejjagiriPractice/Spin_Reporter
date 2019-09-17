package com.spin.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spin.main.model.UserOtp;
import com.spin.main.repository.UserOtpRepository;

@Service
public class UserOtpService {

	@Autowired
	private UserOtpRepository userOtpRepository;
	

	public UserOtp saveUserOtp(UserOtp userOtp) {
		UserOtp userId = userOtpRepository.save(userOtp);
		return userId;
	}

	public UserOtp getUserOtp(Integer userid, Integer isactive) {
		System.out.println("this is UserOtp service" + userid + isactive);

		UserOtp userOtp = userOtpRepository.getUserOtp(userid, isactive);
		return userOtp;
	}
	
	public int updateExictUserOtp( java.util.Date createdon,Integer isactive,String otpcode, Integer otpId) {
		System.out.println("this is UserOtp service" + isactive + otpcode + otpId);

		Integer updated= userOtpRepository.updateExictUserOtp(createdon, isactive, otpcode, otpId);
		return updated;
	}

	public int updateUserOtp(Integer isactive,  java.util.Date  usedon, Integer otpId) {
		System.out.println("this is UserOtp service" + isactive + usedon + otpId);

		Integer updated = userOtpRepository.updateUserOtp(isactive, usedon, otpId);
		return updated;
	}

	public UserOtp exitUserOtp(Integer userid) {

		UserOtp exitUserOtp = userOtpRepository.getExitUserOtp(userid);
		return exitUserOtp;
	}

}
