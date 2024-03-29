package com.kpmg.te.retail.supplierportal.userManagement.entity;

public class UserMaster {

	private String userId;
	private String username;
	private String emailId;
	private String mobileNumber;
	private String userMapping;

	//private Modules modules;
	//private SupplierSite supplierSites;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserMapping() {
		return userMapping;
	}

	public void setUserMapping(String userMapping) {
		this.userMapping = userMapping;
	}


	@Override
	public String toString() {
		return "UserMaster [userId=" + userId + ", username=" + username + ", emailId=" + emailId + ", mobileNumber="
				+ mobileNumber + ", userMapping=" + userMapping + "]";
	}

}
