package com.spin.main.model;
//sandeepK

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class usertypemaster {
	
	@Id
	private Integer usetypeid;
	private  String usertypename;
	private Integer isactive;
	


	public usertypemaster() {
		super();
	}


	public usertypemaster(Integer usetypeid, String usertypename, Integer isactive) {

	}

	

	public Integer getUsetypeid() {
		return usetypeid;
	}

	public void setUsetypeid(Integer usetypeid) {
		this.usetypeid = usetypeid;
	}

	public String getUsertypename() {
		return usertypename;
	}

	public void setUsertypename(String usertypename) {
		this.usertypename = usertypename;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	
	
	

}
