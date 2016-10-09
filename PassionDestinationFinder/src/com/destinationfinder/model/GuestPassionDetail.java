package com.destinationfinder.model;

import java.util.Set;

public class GuestPassionDetail {
	
	
	public GuestPassionDetail(int noOfPassions, Set<String> passions) {
		this.noOfPassions = noOfPassions;
		this.passions = passions;
	}
	
	int noOfPassions;
	public int getNoOfPassions() {
		return noOfPassions;
	}
	
	public Set<String> getPassions() {
		return passions;
	}
	Set<String> passions;
	
	

}
