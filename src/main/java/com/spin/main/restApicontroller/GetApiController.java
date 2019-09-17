package com.spin.main.restApicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spin.main.model.categorymaster;
import com.spin.main.model.citymaster;
import com.spin.main.model.countrymaster;
import com.spin.main.model.languagemaster;
import com.spin.main.model.statemaster;
import com.spin.main.model.subcategorymaster;
import com.spin.main.responsemodel.CategoryWrapper;
import com.spin.main.responsemodel.CityWrapper;
import com.spin.main.responsemodel.CountryWrapper;
import com.spin.main.responsemodel.Errorcodes;
import com.spin.main.responsemodel.LanguageWrapper;
import com.spin.main.responsemodel.StateWrapper;
import com.spin.main.responsemodel.SubCategoryWrapper;
import com.spin.main.service.UsermasterService;

@RestController
@RequestMapping("/api")
public class GetApiController {
	@Autowired
	private UsermasterService userService;
	
	

	@GetMapping(value="/GetContriesApi",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CountryWrapper> userDetails(countrymaster c) {

		List<countrymaster> s = userService.getCountry();
		if (null != s) {
			CountryWrapper r = new CountryWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("success");
			r.setInfo(info);
			r.setCountries(s);

			// return Info;
			return new ResponseEntity<CountryWrapper>(r, HttpStatus.OK);

		} else {
			CountryWrapper r = new CountryWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("failed to load data");
			r.setInfo(info);
			// return Info;
			return new ResponseEntity<CountryWrapper>(r, HttpStatus.OK);

		}

	}
	@GetMapping(value="/GetStatesApi",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StateWrapper> GetState(statemaster c) {

		List<statemaster> s = userService.getState();
		if (null != s) {
			StateWrapper r = new StateWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("success");
			r.setInfo(info);
			r.setStates(s);

			// return Info;
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

	/*@GetMapping(value="/GetCityApi",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CityWrapper> GetCity(citymaster c) {

		List<citymaster> s = userService.getCity();
		if (null != s) {
			CityWrapper r = new CityWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("success");
			r.setInfo(info);
			r.setCities(s);

			// return Info;
			return new ResponseEntity<CityWrapper>(r, HttpStatus.OK);

		} else {
			CityWrapper r = new CityWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("failed to load data");
			r.setInfo(info);
			// return Info;
			return new ResponseEntity<CityWrapper>(r, HttpStatus.OK);

		}

	}*/
	
	@GetMapping(value="/GetLanguagesApi",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LanguageWrapper> GetCity(languagemaster c) {

		List<languagemaster> s = userService.getLanguage();
		if (null != s) {
			LanguageWrapper r = new LanguageWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("success");
			r.setInfo(info);
			r.setLanguages(s);

			// return Info;
			return new ResponseEntity<LanguageWrapper>(r, HttpStatus.OK);

		} else {
			LanguageWrapper r = new LanguageWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("failed to load data");
			r.setInfo(info);
			// return Info;
			return new ResponseEntity<LanguageWrapper>(r, HttpStatus.OK);

		}

	}  
	
	@GetMapping("/GetCountryById/{CountryId}")
	public ResponseEntity<StateWrapper> CountryById(@PathVariable Integer CountryId) {

		List<statemaster> s = userService.getCountryById(CountryId);
		if (null != s) {
			StateWrapper r = new StateWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("success");
			//info.setCurrentId(Id);
			r.setInfo(info);
			r.setStates(s);

			// return Info;
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
		
		@GetMapping("/GetCategoryByid/{CategoryId}")
		public ResponseEntity<SubCategoryWrapper> categoryById(@PathVariable Integer CategoryId) {

			List<subcategorymaster> s = userService.getCategoryById(CategoryId);
			if (null != s) {
				SubCategoryWrapper r = new SubCategoryWrapper();
				Errorcodes info = new Errorcodes();
				info.setErrorCode(1);
				info.setErrorMessage("success");
				//info.setCurrentId(Id);
				r.setInfo(info);
				r.setCategories(s);

				// return Info;
				return new ResponseEntity<SubCategoryWrapper>(r, HttpStatus.OK);

			} else {
				SubCategoryWrapper r = new SubCategoryWrapper();
				Errorcodes info = new Errorcodes();
				info.setErrorCode(0);
				info.setErrorMessage("failed to load data");
				r.setInfo(info);
				// return Info;
				return new ResponseEntity<SubCategoryWrapper>(r, HttpStatus.OK);

			}

		

	}
	
	@GetMapping("/CatogeryById")
	public ResponseEntity<CategoryWrapper> catogeryById(categorymaster category) {

		List<categorymaster> s = userService.getCategory();
		if (null != s) {
			CategoryWrapper r = new CategoryWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("success");
			//info.setCurrentId(Id);
			r.setInfo(info);
			r.setCategories(s);

			// return Info;
			return new ResponseEntity<CategoryWrapper>(r, HttpStatus.OK);

		} else {
			CategoryWrapper r = new CategoryWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("failed to load data");
			r.setInfo(info);
			// return Info;
			return new ResponseEntity<CategoryWrapper>(r, HttpStatus.OK);

		}

	}
	
	@GetMapping("/SubCatogeryById")
	public ResponseEntity<SubCategoryWrapper> subcatogeryById(subcategorymaster category) {

		List<subcategorymaster> s = userService.getsubCategory();
		if (null != s) {
			SubCategoryWrapper r = new SubCategoryWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage("success");
			//info.setCurrentId(Id);
			r.setInfo(info);
			r.setCategories(s);

			// return Info;
			return new ResponseEntity<SubCategoryWrapper>(r, HttpStatus.OK);

		} else {
			SubCategoryWrapper r = new SubCategoryWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("failed to load data");
			r.setInfo(info);
			// return Info;
			return new ResponseEntity<SubCategoryWrapper>(r, HttpStatus.OK);

		}

	}


}
