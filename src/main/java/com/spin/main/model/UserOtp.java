package com.spin.main.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "userotp")
public class UserOtp {

	@Id
	@GeneratedValue(generator="seq")
    @GenericGenerator(name="seq",strategy="increment")
	private Integer otpid;
	@Basic
	@Temporal(TemporalType.DATE)
	private java.util.Date createdon;
	@Basic 
	@Temporal(TemporalType.DATE) 
	private java.util.Date usedon;
	private Integer isactive;
	private String otpcode;
	private Integer userid;

	public UserOtp() {
		super();
	}

	public UserOtp(Integer otpid) {
		super();
		this.otpid = otpid;
	}

	public UserOtp(Integer otpid, Date createdon, Date usedon, Integer isactive, String otpcode, Integer userid) {
		super();
		this.otpid = otpid;
		this.createdon = createdon;
		this.usedon = usedon;
		this.isactive = isactive;
		this.otpcode = otpcode;
		this.userid = userid;
	}

	public Integer getOtpid() {
		return otpid;
	}

	public void setOtpid(Integer otpid) {
		this.otpid = otpid;
	}

	public java.util.Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(java.util.Date createdon) {
		this.createdon = createdon;
	}

	public java.util.Date getUsedon() {
		return usedon;
	}

	public void setUsedon(java.util.Date usedon) {
		this.usedon = usedon;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	public String getOtpcode() {
		return otpcode;
	}

	public void setOtpcode(String otpcode) {
		this.otpcode = otpcode;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "UserOtp [otpid=" + otpid + ", createdon=" + createdon + ", usedon=" + usedon + ", isactive=" + isactive
				+ ", otpcode=" + otpcode + ", userid=" + userid + "]";
	}

}
