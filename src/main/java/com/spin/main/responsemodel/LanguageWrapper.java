package com.spin.main.responsemodel;

import java.util.List;

import com.spin.main.model.languagemaster;

public class LanguageWrapper {
	Errorcodes info;
	List<languagemaster> languages;
	public Errorcodes getInfo() {
		return info;
	}
	public void setInfo(Errorcodes info) {
		this.info = info;
	}
	public List<languagemaster> getLanguages() {
		return languages;
	}
	public void setLanguages(List<languagemaster> languages) {
		this.languages = languages;
	}
	
	


}
