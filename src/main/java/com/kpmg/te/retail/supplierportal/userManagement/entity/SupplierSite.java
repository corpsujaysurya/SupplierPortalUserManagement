package com.kpmg.te.retail.supplierportal.userManagement.entity;

public class SupplierSite {

	private String siteId;
	private String siteName;
	private String siteAddress;
	private String siteLocation;
	private String siteContact;

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public String getSiteLocation() {
		return siteLocation;
	}

	public void setSiteLocation(String siteLocation) {
		this.siteLocation = siteLocation;
	}

	public String getSiteContact() {
		return siteContact;
	}

	public void setSiteContact(String siteContact) {
		this.siteContact = siteContact;
	}

	@Override
	public String toString() {
		return "SupplierSite [siteId=" + siteId + ", siteName=" + siteName + ", siteAddress=" + siteAddress
				+ ", siteLocation=" + siteLocation + ", siteContact=" + siteContact + "]";
	}

}
