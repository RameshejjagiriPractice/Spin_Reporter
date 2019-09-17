package com.spin.main.responsemodel;

import java.util.List;

import com.spin.main.model.subcategorymaster;

public class SubCategoryWrapper {

	Errorcodes info;
	List<subcategorymaster> categories;
	public Errorcodes getInfo() {
		return info;
	}
	public void setInfo(Errorcodes info) {
		this.info = info;
	}
	public List<subcategorymaster> getCategories() {
		return categories;
	}
	public void setCategories(List<subcategorymaster> categories) {
		this.categories = categories;
	}
	
}
