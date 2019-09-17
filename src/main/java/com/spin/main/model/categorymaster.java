package com.spin.main.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class categorymaster {
	
	@Id
	@GeneratedValue(generator="seq")
	@GenericGenerator(name="seq",strategy="increment")

	private Integer categorid;
	private String categoryname;
	private Integer isactive;
	
	public categorymaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public categorymaster(Integer categorid, String categoryname, Integer isactive) {
		super();
		this.categorid = categorid;
		this.categoryname = categoryname;
		this.isactive = isactive;
	}

	public Integer getCategorid() {
		return categorid;
	}

	public void setCategorid(Integer categorid) {
		this.categorid = categorid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	@Override
	public String toString() {
		return "categorymaster [categorid=" + categorid + ", categoryname=" + categoryname + ", isactive=" + isactive
				+ "]";
	}
	
	
	
	

}
