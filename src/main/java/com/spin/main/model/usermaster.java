package com.spin.main.model;
//sandeepK

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("usermaster")

@Entity
@Table(name = "usermaster")
public class usermaster {

	@Id
	@GeneratedValue(generator = "seq")
	@GenericGenerator(name = "seq", strategy = "increment")

	private Integer userid;
	private String username;
	private String emailid;
	private Long mobilenumber;

	private Integer countryid;
	private Integer stateid;
	private Integer cityid;
	private Integer languageid;
	private String pword;
	@Transient
	private String confirmpword;
	private Integer isactive;
	private String curentsatus;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date registredon;
	private Integer usertypeid;
	private String useraddress;
	private String userimage;

	/*
	 * @Transient private String location = "F://SpinReporterUploads";
	 */
	
	@OneToMany(mappedBy="usermaster")
	private List<Postings> postings;

	public usermaster() {
		super();
	}

	public usermaster(Integer userid) {
		super();
		this.userid = userid;
	}

	public usermaster(Integer userid, String username, String emailid, Long mobilenumber, Integer countryid,
			Integer stateid, Integer cityid, Integer languageid, String pword, String confirmpword, Integer isactive,
			String curentsatus, Date registredon, Integer usertypeid, String useraddress, String userimage,
			String location) {
		super();
		this.userid = userid;
		this.username = username;
		this.emailid = emailid;
		this.mobilenumber = mobilenumber;
		this.countryid = countryid;
		this.stateid = stateid;
		this.cityid = cityid;
		this.languageid = languageid;
		this.pword = pword;
		this.confirmpword = confirmpword;
		this.isactive = isactive;
		this.curentsatus = curentsatus;
		this.registredon = registredon;
		this.usertypeid = usertypeid;
		this.useraddress = useraddress;
		this.userimage = userimage;


	}

	





	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public Integer getStateid() {
		return stateid;
	}

	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public Integer getLanguageid() {
		return languageid;
	}

	public void setLanguageid(Integer languageid) {
		this.languageid = languageid;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getConfirmpword() {
		return confirmpword;
	}

	public void setConfirmpword(String confirmpword) {
		this.confirmpword = confirmpword;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	public String getCurentsatus() {
		return curentsatus;
	}

	public void setCurentsatus(String curentsatus) {
		this.curentsatus = curentsatus;
	}

	public Date getRegistredon() {
		return registredon;
	}

	public void setRegistredon(Date registredon) {
		this.registredon = registredon;
	}

	public Integer getUsertypeid() {
		return usertypeid;
	}

	public void setUsertypeid(Integer usertypeid) {
		this.usertypeid = usertypeid;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUserimage() {
		return userimage.substring(23);
	}

	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}

	

	@Override
	public String toString() {
		return "usermaster [userid=" + userid + ", username=" + username + ", emailid=" + emailid + ", mobilenumber="
				+ mobilenumber + ", countryid=" + countryid + ", stateid=" + stateid + ", cityid=" + cityid
				+ ", languageid=" + languageid + ", pword=" + pword + ", confirmpword=" + confirmpword + ", isactive="
				+ isactive + ", curentsatus=" + curentsatus + ", registredon=" + registredon + ", usertypeid="
				+ usertypeid + ", useraddress=" + useraddress + ", userimage=" + userimage +  
				"]";
	}



}
