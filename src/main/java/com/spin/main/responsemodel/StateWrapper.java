package com.spin.main.responsemodel;

import java.util.List;

import com.spin.main.model.statemaster;

public class StateWrapper {
	Errorcodes info;
	List<statemaster> states;
	public Errorcodes getInfo() {
		return info;
	}
	public void setInfo(Errorcodes info) {
		this.info = info;
	}
	public List<statemaster> getStates() {
		return states;
	}
	public void setStates(List<statemaster> states) {
		this.states = states;
	}
	
	
	
}
