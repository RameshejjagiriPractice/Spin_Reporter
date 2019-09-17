package com.spin.main.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("postings")

@Entity
@Table(name = "postings")
public class Postings {
	@GeneratedValue
	@Id
	private Integer postid;
	private Integer postingtypeid;
	private String posttitle;
	private String postdescription;

	private Integer categoryid;

	private Integer countryid;
	private Integer stateid;
	private Integer cityid;
	private Integer languageid;
	private Date dateofposting;
	private Integer postprice;
	public Integer isactive;
	private Date expirydate;
	private String currentsatus;
	private Integer expiredby;
	public Integer lastmodifiedby;
	public Date lastmodifiedon;
	private String preview;
	private String thumnail;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private usermaster usermaster;

	public Postings() {
		super();
	}

	public Postings(Integer postid) {
		super();
		this.postid = postid;
	}

	public Postings(Integer postid, Integer postingtypeid, String posttitle, String postdescription, Integer categoryid,
			Integer countryid, Integer stateid, Integer cityid, Integer languageid, Date dateofposting,
			Integer postprice, Integer isactive, Date expirydate, String currentsatus, Integer expiredby,
			Integer lastmodifiedby, Date lastmodifiedon, String preview, String thumnail,
			com.spin.main.model.usermaster usermaster) {
		super();
		this.postid = postid;
		this.postingtypeid = postingtypeid;
		this.posttitle = posttitle;
		this.postdescription = postdescription;
		this.categoryid = categoryid;
		this.countryid = countryid;
		this.stateid = stateid;
		this.cityid = cityid;
		this.languageid = languageid;
		this.dateofposting = dateofposting;
		this.postprice = postprice;
		this.isactive = isactive;
		this.expirydate = expirydate;
		this.currentsatus = currentsatus;
		this.expiredby = expiredby;
		this.lastmodifiedby = lastmodifiedby;
		this.lastmodifiedon = lastmodifiedon;
		this.preview = preview;
		this.thumnail = thumnail;
		this.usermaster = usermaster;
	}

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public Integer getPostingtypeid() {
		return postingtypeid;
	}

	public void setPostingtypeid(Integer postingtypeid) {
		this.postingtypeid = postingtypeid;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPostdescription() {
		return postdescription;
	}

	public void setPostdescription(String postdescription) {
		this.postdescription = postdescription;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
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

	public Date getDateofposting() {
		return dateofposting;
	}

	public void setDateofposting(Date dateofposting) {
		this.dateofposting = dateofposting;
	}

	public Integer getPostprice() {
		return postprice;
	}

	public void setPostprice(Integer postprice) {
		this.postprice = postprice;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public String getCurrentsatus() {
		return currentsatus;
	}

	public void setCurrentsatus(String currentsatus) {
		this.currentsatus = currentsatus;
	}

	public Integer getExpiredby() {
		return expiredby;
	}

	public void setExpiredby(Integer expiredby) {
		this.expiredby = expiredby;
	}

	public Integer getLastmodifiedby() {
		return lastmodifiedby;
	}

	public void setLastmodifiedby(Integer lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}

	public Date getLastmodifiedon() {
		return lastmodifiedon;
	}

	public void setLastmodifiedon(Date lastmodifiedon) {
		this.lastmodifiedon = lastmodifiedon;
	}

	public String getPreview() {
		return preview.substring(23);
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getThumnail() {
		return thumnail.substring(23);
	}

	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}

	public usermaster getUsermaster() {
		return usermaster;
	}

	public void setUsermaster(usermaster usermaster) {
		this.usermaster = usermaster;
	}

	@Override
	public String toString() {
		return "Postings [postid=" + postid + ", postingtypeid=" + postingtypeid + ", posttitle=" + posttitle
				+ ", postdescription=" + postdescription + ", categoryid=" + categoryid + ", countryid=" + countryid
				+ ", stateid=" + stateid + ", cityid=" + cityid + ", languageid=" + languageid + ", dateofposting="
				+ dateofposting + ", postprice=" + postprice + ", isactive=" + isactive + ", expirydate=" + expirydate
				+ ", currentsatus=" + currentsatus + ", expiredby=" + expiredby + ", lastmodifiedby=" + lastmodifiedby
				+ ", lastmodifiedon=" + lastmodifiedon + ", preview=" + preview + ", thumnail=" + thumnail
				+ ", usermaster=" + usermaster + "]";
	}

}