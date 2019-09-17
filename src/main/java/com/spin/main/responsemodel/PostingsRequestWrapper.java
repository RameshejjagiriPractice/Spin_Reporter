package com.spin.main.responsemodel;

import java.util.List;

import com.spin.main.model.Postings;

public class PostingsRequestWrapper {
	
	public  Errorcodes info;
	public List<Postings> postings;


	

	public Errorcodes getInfo() {
		return info;
	}

	public void setInfo(Errorcodes info) {
		this.info = info;
	}

	public List<Postings> getPostings() {
		return postings;
	}

	public void setPostings(List<Postings> postings) {
		this.postings = postings;
	}

	

	
	
	

}
