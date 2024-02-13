package com.kpmg.te.retail.supplierportal.userManagement.entity;

public class UserMaster {

	private String userId;
	private String username;
	private String emailId;
	private String mobileNumber;
	private String userMapping;
	private String password;
	private String defaultPwdFlag;
	private String isAdminFlag;
	private String tempOtp;
	private String redirectFlag;

	// private Modules modules;
	// private SupplierSite supplierSites;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDefaultPwdFlag() {
		return defaultPwdFlag;
	}

	public void setDefaultPwdFlag(String defaultPwdFlag) {
		this.defaultPwdFlag = defaultPwdFlag;
	}

	public String getIsAdminFlag() {
		return isAdminFlag;
	}

	public void setIsAdminFlag(String isAdminFlag) {
		this.isAdminFlag = isAdminFlag;
	}

	public String getTempOtp() {
		return tempOtp;
	}

	public void setTempOtp(String tempOtp) {
		this.tempOtp = tempOtp;
	}

	public String getRedirectFlag() {
		return redirectFlag;
	}

	public void setRedirectFlag(String redirectFlag) {
		this.redirectFlag = redirectFlag;
	}

	@Override
	public String toString() {
		return "UserMaster [userId=" + userId + ", username=" + username + ", emailId=" + emailId + ", mobileNumber="
				+ mobileNumber + ", userMapping=" + userMapping + ", password=" + password + ", defaultPwdFlag="
				+ defaultPwdFlag + ", isAdminFlag=" + isAdminFlag + ", tempOtp=" + tempOtp + ", redirectFlag="
				+ redirectFlag + "]";
	}

}
