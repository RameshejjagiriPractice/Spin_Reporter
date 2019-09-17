/*package com.spin.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spin.main.model.Login;
import com.spin.main.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;


	 
	public List<Login> loginSpinReporterUserEmail() {

		List<Login> allLoginUsers = (List<Login>) loginRepository.findAll();
		for (Login login : allLoginUsers) { 
			System.out.println(login);
		}

		return allLoginUsers;
	}

	public Login findBySpringReporterUserName(String spinReporterUserName) {

		Login login=loginRepository.findBySpinReporterUserName(spinReporterUserName);

		System.out.println("=================="+login);
		return login;
	}

	public void  updatePassword(String reEnterPassword,Integer id) {

		loginRepository.updatePassword(reEnterPassword, id);

	}
}*/
