package com.spin.main.responsemodel;

import java.util.List;

import com.spin.main.model.Postings;

public class PostingWrapper {

	Errorcodes info;
	List<Postings> data;

	public Errorcodes getInfo() {
		return info;
	}

	public void setInfo(Errorcodes info) {
		this.info = info;
	}

	public List<Postings> getData() {
		return data;
	}

	public void setData(List<Postings> data) {
		this.data = data;
	}

	
}
