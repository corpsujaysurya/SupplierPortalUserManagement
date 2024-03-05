package com.kpmg.te.retail.supplierportal.userManagement.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.te.retail.supplierportal.userManagement.controller.SupplierPortalUserManagementController;
import com.kpmg.te.retail.supplierportal.userManagement.entity.SupplierSite;
import com.kpmg.te.retail.supplierportal.userManagement.entity.UserMaster;
import com.kpmg.te.retail.supplierportal.userManagement.manager.SupplierPortalUserManagementManager;

@RestController
@RequestMapping("/api/usermgmt/service/")
public class SupplierPortalUserManagementService {
	
	@Autowired
	SupplierPortalUserManagementController supplierPortalUserManagementController;
	
	@Autowired
	SupplierPortalUserManagementManager supplierPortalUserManagementManager;
	
	
	private static final Logger logger = Logger.getLogger(SupplierPortalUserManagementService.class.getName());
	
	/************************************************************************************************************************************************************************** */
	/*													USER MANAGEMENT - VIEW /EDIT USER REST END-POINTS                                                                      */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "/user/vieweUserMaster", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<UserMaster> viewUserDetails() throws ClassNotFoundException, SQLException {
		logger.info("Hello world");
		return supplierPortalUserManagementController.viewUserData();
	}
	
	@RequestMapping(path = "/user/getUserDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserMaster getUserDetails(@RequestParam String userId) throws ClassNotFoundException, SQLException {
		return supplierPortalUserManagementController.getUserDetails(userId);
	}
	
	@RequestMapping(path = "/user/editUserDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	public String editUserDetails(@RequestBody UserMaster userMaster) throws ClassNotFoundException, SQLException {
		return supplierPortalUserManagementController.updateUserDetails(userMaster);
	}
	

	
	/************************************************************************************************************************************************************************** */
	/*													USER MANAGEMENT - CREATE /DELETE USER REST END-POINTS                                                                  */
	/**************************************************************************************************************************************************************************/

@RequestMapping(path="/user/createUser",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
public String createNewUser(@RequestBody UserMaster userMaster) throws ClassNotFoundException, SQLException {
	String creationStatus;
	logger.info("The User Master Obj to display is: " + userMaster.toString());
	creationStatus = supplierPortalUserManagementController.createNewUser(userMaster);
	return creationStatus;
}

	@RequestMapping(path = "/user/deleteUserDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public String deleteUser(@RequestParam String userId) throws ClassNotFoundException, SQLException {
		return supplierPortalUserManagementController.deleteUser(userId);
	}
	
	/************************************************************************************************************************************************************************** */
	/* 													USER MANAGEMENT - CREATE / MODIFY / DELETE / VIEW SUPPLIER SITES */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "/sites/getAllSupplierSites", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<SupplierSite> getAllSupplierSites() throws ClassNotFoundException, SQLException {
		ArrayList<SupplierSite> siteList = new ArrayList<SupplierSite>();
		siteList = supplierPortalUserManagementController.getAllSiteData();
		logger.info("The Site List to display is: " + siteList.toString());
		return siteList;
	}

	@RequestMapping(path = "/sites/editSupplierSite", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String editSupplierSite(@RequestBody SupplierSite supplierSite) throws ClassNotFoundException, SQLException {
		return supplierPortalUserManagementController.updateSuppliersiteData(supplierSite);
	}

	@RequestMapping(path = "/sites/deleteSupplierSite", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteSupplierSite(@RequestParam String supplierSiteId)
			throws ClassNotFoundException, SQLException {
		return supplierPortalUserManagementController.deleteSuppliersiteData(supplierSiteId);
	}

	@RequestMapping(path = "/sites/addNewSupplierSite", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addNewSupplierSite(@RequestBody SupplierSite supplierSite)
			throws ClassNotFoundException, SQLException {
		return supplierPortalUserManagementController.createSuppliersiteData(supplierSite);
	}

	/************************************************************************************************************************************************************************** */
	/*													USER MANAGEMENT - USER LOGIN					                                                                       */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "user/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserMaster userLogin(@RequestParam String userId,@RequestParam String password)
			throws ClassNotFoundException, SQLException {
		return supplierPortalUserManagementController.userLogin(userId,password);
	}
	
	@RequestMapping(path = "user/resetPwd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String resetPwd(@RequestParam String userId,@RequestParam String newPassword)
			throws ClassNotFoundException, SQLException {
		return supplierPortalUserManagementController.setNewPwd(userId,newPassword);
	}
	
	  @RequestMapping(path = "user/updateProfile", method = RequestMethod.POST,
	  produces = MediaType.APPLICATION_JSON_VALUE) public String
	  resetPwd(@RequestParam String userId,@RequestParam String userName,@RequestParam String userEmail, @RequestParam String userPhoneNo) throws ClassNotFoundException,
	  SQLException { 
		  return supplierPortalUserManagementController.updateProfile(userId,userName,userEmail,userPhoneNo);
	  }
	  
	 
	
	
}
