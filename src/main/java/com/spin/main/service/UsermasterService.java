package com.spin.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spin.main.model.categorymaster;
import com.spin.main.model.citymaster;
import com.spin.main.model.countrymaster;
import com.spin.main.model.languagemaster;
import com.spin.main.model.statemaster;
import com.spin.main.model.subcategorymaster;
import com.spin.main.model.usermaster;
import com.spin.main.repository.CategoryRepository;
import com.spin.main.repository.CityRepository;
import com.spin.main.repository.CountryRepository;
import com.spin.main.repository.LanguageRepository;
import com.spin.main.repository.StateRepository;
import com.spin.main.repository.SubCategoryRepository;
import com.spin.main.repository.usermasterRepository;

@Service
public class UsermasterService {

	@Autowired
	private usermasterRepository userRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private CategoryRepository categorRepository;
	@Autowired
	private SubCategoryRepository subcategorRepository;

	@Autowired
	private CityRepository cityRepository;

	public long allUserCount() {

		return userRepository.allUsersCount();
	}

	// private static List<Signup> users;
	public List<usermaster> getUser() {
		List<usermaster> list = new ArrayList<>();
		userRepository.findAll().forEach(list::add);

		return list;

	}

	public List<countrymaster> getCountry() {
		List<countrymaster> list = new ArrayList<>();
		countryRepository.findAll().forEach(list::add);
		return list;

	}

	public List<statemaster> getState() {
		List<statemaster> list = new ArrayList<>();
		stateRepository.findAll().forEach(list::add);
		return list;

	}

	public List<citymaster> getCity() {
		List<citymaster> list = new ArrayList<>();
		cityRepository.findAll().forEach(list::add);
		return list;
	}

	/*
	 * public List<citymaster> getCity() { List<citymaster> list = new
	 * ArrayList<>(); cityRepository.findAll().forEach(list::add); return list;
	 */

	public List<languagemaster> getLanguage() {
		List<languagemaster> list = new ArrayList<>();
		languageRepository.findAll().forEach(list::add);
		return list;

	}

	public List<categorymaster> getCategory() {
		List<categorymaster> list = new ArrayList<>();
		categorRepository.findAll().forEach(list::add);
		return list;

	}

	public List<subcategorymaster> getsubCategory() {
		List<subcategorymaster> list = new ArrayList<>();
		subcategorRepository.findAll().forEach(list::add);
		return list;

	}

	public usermaster getUserByID(Integer loginId) {

		usermaster s = userRepository.userById(loginId);

		return s;

	}

	public List<statemaster> getCountryById(Integer CountryId) {
		List<statemaster> list = new ArrayList<>();
		stateRepository.countryById(CountryId).forEach(list::add);
		return list;
	}

	public List<subcategorymaster> getCategoryById(Integer CategoryId) {
		List<subcategorymaster> s = subcategorRepository.CategoryById(CategoryId);
		return s;
	}

	public void addUser(usermaster user) {
		userRepository.save(user);

	}

	// -----------------------------------------------------AndeRanjith----------------------------------------------------------------------------------------

	public List<usermaster> loginSpinReporterUserEmail() {

		List<usermaster> allusermaster = (List<usermaster>) userRepository.findAll();
		for (usermaster usermaster : allusermaster) {
			System.out.println(usermaster);
		}

		return allusermaster;
	}

	public usermaster findBySpringReporterUserName(String spinReporterUserName) {

		usermaster usermaster = userRepository.findBySpinReporterUserName(spinReporterUserName);

		System.out.println("==================" + usermaster);
		return usermaster;
	}

	public void updatePassword(String reEnterPassword, Integer id) {

		userRepository.updatePassword(reEnterPassword, id);

	}

	// -----------------------------------------------------AndeRanjith----------------------------------------------------------------------------------------

}