package com.spin.main.model;
//sandeepK

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class statemaster {
	@Id
	@GeneratedValue(generator = "seq")
	@GenericGenerator(name = "seq", strategy = "increment")

	private Integer stateid;
	private String statename;
	private Integer isactive;
	private Integer countryid;
	private String statecode;

	public Integer getStateid() {
		return stateid;
	}

	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public String getStatecode() {
		return statecode;
	}

	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

}
