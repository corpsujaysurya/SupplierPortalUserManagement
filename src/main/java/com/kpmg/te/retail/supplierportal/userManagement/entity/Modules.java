package com.kpmg.te.retail.supplierportal.userManagement.entity;

public class Modules {
	
	private String moduleId;
	private String moduleName;
	
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	@Override
	public String toString() {
		return "Modules [moduleId=" + moduleId + ", moduleName=" + moduleName + "]";
	}
	
	
	

}
