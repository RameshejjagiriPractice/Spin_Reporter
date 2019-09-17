package com.spin.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spin.main.model.categorymaster;
import com.spin.main.model.countrymaster;
import com.spin.main.model.languagemaster;
import com.spin.main.model.statemaster;
import com.spin.main.model.subcategorymaster;
import com.spin.main.repository.CategoryRepository;
import com.spin.main.repository.CountryRepository;
import com.spin.main.repository.LanguageRepository;
import com.spin.main.repository.StateRepository;
import com.spin.main.repository.SubCategoryRepository;

@Service
public class AdminService {
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private LanguageRepository languageRepository;
	

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	public countrymaster createCountry(countrymaster countries) {
		return countryRepository.save(countries);
	}

	public statemaster createState(statemaster values) {
		return stateRepository.save(values);
	}

	public subcategorymaster createSubcat(subcategorymaster subcat) {
		return subCategoryRepository.save(subcat);
	}

	public  categorymaster createCategory(categorymaster listCategories) {
		return categoryRepository.save(listCategories);
	}


	public languagemaster createLanguage(languagemaster listlanguages)
	{
		return languageRepository.save(listlanguages);
	}
	

	/*
	 * public usermaster findById(Integer userid) {
	 * 
	 * usermaster userview = userRepository.findBy(userid);
	 * 
	 * return userview; }
	 */


}
