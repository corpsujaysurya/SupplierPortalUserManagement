package com.kpmg.te.retail.supplierportal.userManagement.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.userManagement.dao.SupplierPortalUserManagementDao;
import com.kpmg.te.retail.supplierportal.userManagement.entity.SupplierSite;
import com.kpmg.te.retail.supplierportal.userManagement.entity.UserMaster;
import com.kpmg.te.retail.supplierportal.userManagement.entity.ViewUserHomePage;


@Component
public class SupplierPortalController {
	
	private static final Logger logger = Logger.getLogger(SupplierPortalController.class.getName());
	
	@Autowired
	SupplierPortalUserManagementDao umDao;
	
	
	/************************************************************************************************************************************************************************** */
	/* 													USER MANAGEMENT - CREATE / MODIFY / DELETE / VIEW USER DETAILS */
	/**************************************************************************************************************************************************************************/	

	public ViewUserHomePage viewUserData() throws ClassNotFoundException, SQLException {
		ViewUserHomePage vUh = new ViewUserHomePage();
		vUh.setUserMasterList(umDao.getBasicUserList());
		vUh.setModulesList(umDao.getBasicModuleData());
		vUh.setSupplieSiteList(umDao.getBasicSupplierSiteData());
		return vUh;
	}

	public UserMaster getUserDetails(String userId) throws ClassNotFoundException, SQLException {
		UserMaster um = new UserMaster();
		um = umDao.getUserDetails(userId);
		logger.info(um.toString());
		return um;
	}

	public String updateUserDetails(UserMaster userMaster) throws ClassNotFoundException, SQLException {
		String upadateMsg;
		upadateMsg = umDao.updateUserDetails(userMaster);
		return upadateMsg;
	}

	public String deleteUser(String userName) throws ClassNotFoundException, SQLException {
		String deleteMsg;
		deleteMsg = umDao.deleteUser(userName);
		return deleteMsg;
	}

	public String createNewUser(UserMaster userMaster) throws ClassNotFoundException, SQLException {
		String creationMsg;
		creationMsg = umDao.createUser(userMaster);
		return creationMsg;
	}
	
	/************************************************************************************************************************************************************************** */
	/* 													USER MANAGEMENT - CREATE / MODIFY / DELETE / VIEW SUPPLIER SITES 													  */
	/************************************************************************************************************************************************************************/
	public ArrayList<SupplierSite> getAllSiteData() throws ClassNotFoundException, SQLException {
		return umDao.getAllSupplierSite();
	}

	public String updateSuppliersiteData(SupplierSite supplierSite) throws ClassNotFoundException, SQLException {
		String updateMsg;
		updateMsg = umDao.updateSupplierSite(supplierSite);
		return updateMsg;
	}

	public String deleteSuppliersiteData(String supplierSiteName) throws ClassNotFoundException, SQLException {
		String deleteMsg;
		deleteMsg = umDao.deleteSupplierSite(supplierSiteName);
		return deleteMsg;
	}

	public java.lang.String createSuppliersiteData(SupplierSite supplierSite)
			throws ClassNotFoundException, SQLException {
		String creationMsg;
		creationMsg = umDao.createSupplierSite(supplierSite);
		return creationMsg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	  

	 

	

}
