package com.spin.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class subcategorymaster {
	
	@Id
	@GeneratedValue(generator="seq")
	@GenericGenerator(name="seq",strategy="increment")

	private Integer subcategorid;
	private String subcategoryname;
	@Column(name="categoryid")
	private Integer categoryid;
	private Integer isactive;
	
	public subcategorymaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public subcategorymaster(Integer subcategorid, String subcategoryname, Integer categoryid, Integer isactive) {
		super();
		this.subcategorid = subcategorid;
		this.subcategoryname = subcategoryname;
		this.categoryid = categoryid;
		this.isactive = isactive;
	}

	public Integer getSubcategorid() {
		return subcategorid;
	}

	public void setSubcategorid(Integer subcategorid) {
		this.subcategorid = subcategorid;
	}

	public String getSubcategoryname() {
		return subcategoryname;
	}

	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	@Override
	public String toString() {
		return "subcategorymaster [subcategorid=" + subcategorid + ", subcategoryname=" + subcategoryname
				+ ", categoryid=" + categoryid + ", isactive=" + isactive + "]";
	}




}