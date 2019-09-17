package com.spin.main.model;
//sandeepK
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table
@Entity
public class languagemaster {
	@Id
	@GeneratedValue(generator="seq")
	@GenericGenerator(name="seq",strategy="increment")


	private Integer languageid;
	private String languagename;
	private Integer isactive;

	public Integer getLanguageid() {
		return languageid;
	}

	public void setLanguageid(Integer languageid) {
		this.languageid = languageid;
	}

	public String getLanguagename() {
		return languagename;
	}

	public void setLanguagename(String languagename) {
		this.languagename = languagename;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

}
