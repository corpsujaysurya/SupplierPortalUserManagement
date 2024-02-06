package com.kpmg.te.retail.supplierportal.userManagement.entity;

import java.util.ArrayList;

public class ViewUserHomePage {

	private ArrayList<String> userMasterList;
	private ArrayList<String> supplieSiteList;
	private ArrayList<String> modulesList;

	public ArrayList<String> getUserMasterList() {
		return userMasterList;
	}

	public void setUserMasterList(ArrayList<String> userMasterList) {
		this.userMasterList = userMasterList;
	}

	public ArrayList<String> getSupplieSiteList() {
		return supplieSiteList;
	}

	public void setSupplieSiteList(ArrayList<String> supplieSiteList) {
		this.supplieSiteList = supplieSiteList;
	}

	public ArrayList<String> getModulesList() {
		return modulesList;
	}

	public void setModulesList(ArrayList<String> modulesList) {
		this.modulesList = modulesList;
	}

	@Override
	public String toString() {
		return "ViewUserHomePage [userMasterList=" + userMasterList + ", supplieSiteList=" + supplieSiteList
				+ ", modulesList=" + modulesList + "]";
	}

}
