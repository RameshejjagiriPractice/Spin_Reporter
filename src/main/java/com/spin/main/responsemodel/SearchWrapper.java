package com.spin.main.responsemodel;

import java.util.List;

import com.spin.main.model.Postings;

public class SearchWrapper {
	
	Errorcodes info;
	List<Postings> postlist;
	
	

	
	public List<Postings> getPostlist() {
		return postlist;
	}

	public void setPostlist(List<Postings> postlist) {
		this.postlist = postlist;
	}

	public Errorcodes getInfo() {
		return info;
	}

	public void setInfo(Errorcodes info) {
		this.info = info;
	}
	
	
	

}
