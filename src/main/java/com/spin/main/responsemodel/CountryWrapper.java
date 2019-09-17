package com.spin.main.responsemodel;

import java.util.List;


import com.spin.main.model.countrymaster;


public class CountryWrapper {

	Errorcodes info;
	List<countrymaster> countries;
	
	public Errorcodes getInfo() {
		return info;
	}
	public void setInfo(Errorcodes info) {
		this.info = info;
	}
	
	
	public List<countrymaster> getCountries() {
		return countries;
	}
	public void setCountries(List<countrymaster> countries) {
		this.countries = countries;
	}
	
	
	
	
}
