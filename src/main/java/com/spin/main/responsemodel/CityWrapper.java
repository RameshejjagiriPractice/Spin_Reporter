package com.spin.main.responsemodel;

import java.util.List;

import com.spin.main.model.citymaster;

public class CityWrapper {

	Errorcodes info;
	List<citymaster> cities;
	public Errorcodes getInfo() {
		return info;
	}
	public void setInfo(Errorcodes info) {
		this.info = info;
	}
	public List<citymaster> getCities() {
		return cities;
	}
	public void setCities(List<citymaster> cities) {
		this.cities = cities;
	}
	
	

}
