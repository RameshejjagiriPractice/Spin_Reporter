package com.spin.main.responsemodel;

import java.util.List;

import com.spin.main.model.categorymaster;

public class CategoryWrapper {
	
	
	Errorcodes info;
	List<categorymaster> categories;
	public Errorcodes getInfo() {
		return info;
	}
	public void setInfo(Errorcodes info) {
		this.info = info;
	}
	public List<categorymaster> getCategories() {
		return categories;
	}
	public void setCategories(List<categorymaster> categories) {
		this.categories = categories;
	}
	
	

}
