package com.spin.main.model;

//sandeepK
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class countrymaster {
	@Id
	@GeneratedValue(generator="seq")
	@GenericGenerator(name="seq",strategy="increment")

	private Integer countryid;
	private String countryname;
	private Integer isactive;
	private String countrycode;
	private String phonecode;

	// select * ,countrymaster.countryname from usermaster inner join countrymaster
	// on usermaster.countryid=countrymaster.countryid where usermaster.userid=2;

	public countrymaster() {
		super();
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(String phonecode) {
		this.phonecode = phonecode;
	}

}
