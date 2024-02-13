package com.kpmg.te.retail.supplierportal.userManagement.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.userManagement.dao.SupplierPortalUserManagementDao;



@Component
public class SupplierPortalLoginManager {
	
	@Autowired
	SupplierPortalUserManagementDao loginDao;

	
}
