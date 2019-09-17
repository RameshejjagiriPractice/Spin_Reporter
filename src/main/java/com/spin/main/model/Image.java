package com.spin.main.model;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("image")

public class Image {
	
	private String location= "F://SpinReporterUploads";
	
	


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Image(String location) {
		super();
		this.location = location;
	}

	public Image() {
		super();
	}
	
	
	

}
