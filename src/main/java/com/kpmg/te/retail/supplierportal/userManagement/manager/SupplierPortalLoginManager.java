package com.kpmg.te.retail.supplierportal.userManagement.manager;

import java.nio.charset.StandardCharsets;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.userManagement.dao.SupplierPortalUserManagementDao;


import jakarta.validation.Valid;

@Component
public class SupplierPortalLoginManager {
	
	@Autowired
	SupplierPortalUserManagementDao loginDao;

	
}
