package com.spin.main.responsemodel;
//sandeepK

import com.spin.main.model.usermaster;

public class RequestWrapper {
	Errorcodes info;
	usermaster data;
	public Errorcodes getInfo() {
		return info;
	}
	public void setInfo(Errorcodes info) {
		this.info = info;
	}
	public usermaster getData() {
		return data;
	}
	public void setData(usermaster data) {
		this.data = data;
	}
	
	


}
