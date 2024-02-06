package com.kpmg.te.retail.supplierportal.userManagement.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.userManagement.constants.SQLConstants;
import com.kpmg.te.retail.supplierportal.userManagement.entity.SupplierSite;
import com.kpmg.te.retail.supplierportal.userManagement.entity.UserMaster;
import com.kpmg.te.retail.supplierportal.userManagement.utils.UserManagementUtils;

@Component
public class SupplierPortalUserManagementDao {

	private static final Logger logger = Logger.getLogger(SupplierPortalUserManagementDao.class.getName());
	
	@Autowired
	UserManagementUtils umUtils;

	public Connection getConnectioDetails() throws ClassNotFoundException, SQLException {
		String myDriver = SQLConstants.myDriver;
		String myUrl = SQLConstants.myUrl;
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, SQLConstants.mySQL_ID, SQLConstants.mySQL_pass);
		return conn;
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}


	
/*******************************************************************************************************************************************************/	
	public ArrayList<String> getBasicUserList() throws ClassNotFoundException, SQLException {
		String userObj;
		ArrayList<String> userList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  user_name from SUPPLIER_PORTAL.supplier_user_master";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			userObj = new String();
			userObj = rs.getString("user_name");
			userList.add(userObj);
		}
		logger.info("SupplierSite list is: " + userList.toString());
		return userList;
	}
	
	public ArrayList<String> getBasicModuleData() throws ClassNotFoundException, SQLException {
		String moduleName;
		ArrayList<String> modulesNameList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  module_name from supplier_portal_module";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			moduleName = new String();
			moduleName = rs.getString("module_name");
			modulesNameList.add(moduleName);
		}
		logger.info("Modules Name list is: " + modulesNameList.toString());
		return modulesNameList;
	}

	
	public ArrayList<String> getBasicSupplierSiteData() throws ClassNotFoundException, SQLException {
		String siteName;
		ArrayList<String> siteList = new ArrayList<String>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  site_name from supplier_portal_sites";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			siteName = new String();
			siteName = rs.getString("site_name");
			siteList.add(siteName);
		}
		logger.info("Modules Name list is: " + siteList.toString());
		return siteList;
	}
	
	
	
/*******************************************************************************************************************************************************/	
	
	public UserMaster getUserDetails(String userName) throws ClassNotFoundException, SQLException {
		UserMaster um = new UserMaster();
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.SUPPLIER_USER_MASTER WHERE USER_NAME='"+ userName +"'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			um.setUserMapping(rs.getString("USER_MAPPING"));
			um.setUserId(rs.getString("user_id"));
			um.setEmailId(rs.getString("user_email"));
			um.setMobileNumber(rs.getString("user_mobile"));
			um.setUsername(userName);
		}
		logger.info("User Details is: " + um.toString());
		return um;
	}

public String updateUserDetails(UserMaster userMaster) throws ClassNotFoundException, SQLException {
	String updateStatus;
	Connection conn = getConnectioDetails();
	String query = "UPDATE SUPPLIER_PORTAL.SUPPLIER_USER_MASTER SET USER_EMAIL = ?,USER_MOBILE = ?, USER_MAPPING = ?  WHERE USER_NAME = ?  ";
	logger.info(query);
	PreparedStatement pstmt = conn.prepareStatement(query);
	pstmt.setString(1, userMaster.getEmailId());
	pstmt.setString(2, userMaster.getMobileNumber());
	pstmt.setString(3, userMaster.getUserMapping());
	pstmt.setString(4, userMaster.getUsername());
	int updateStatusCode = pstmt.executeUpdate();
	logger.info(Integer.toString(updateStatusCode));
	updateStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
	pstmt.close();
	return updateStatus;
}

public String deleteUser(String userName) throws SQLException, ClassNotFoundException {
	String deleteStatus;
	Connection conn = getConnectioDetails();
	String query = "DELETE FROM SUPPLIER_PORTAL.SUPPLIER_USER_MASTER WHERE USER_NAME = ?";
	logger.info(query);
	PreparedStatement pstmt = conn.prepareStatement(query);
	pstmt.setString(1, userName);
	int updateStatusCode = pstmt.executeUpdate();
	logger.info(Integer.toString(updateStatusCode));
	deleteStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
	pstmt.close();
	return deleteStatus;
}

public String createUser(UserMaster userMaster) throws ClassNotFoundException, SQLException {
	String creationStatus;
	Connection conn = getConnectioDetails();
	String insertQuery = "INSERT INTO SUPPLIER_PORTAL.SUPPLIER_USER_MASTER(USER_ID, USER_NAME, USER_EMAIL, USER_MOBILE, USER_MAPPING)"
			+ " VALUES" + "(?, ?, ?, ?, ?)";
	logger.info(insertQuery);
	PreparedStatement pstmt = conn.prepareStatement(insertQuery);
	pstmt.setString(1, userMaster.getUserId());
	pstmt.setString(2, userMaster.getUsername());
	pstmt.setString(3, userMaster.getEmailId());
	pstmt.setString(4, userMaster.getMobileNumber());
	pstmt.setString(5, userMaster.getUserMapping());
	int updateStatusCode = pstmt.executeUpdate();
	logger.info(Integer.toString(updateStatusCode));
	creationStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
	pstmt.close();
	return creationStatus;
}
/************************************************************************************************************************************************************************** */
/* 													USER MANAGEMENT - CREATE / MODIFY / DELETE / VIEW SUPPLIER SITES 													   */
/************************************************************************************************************************************************************************/
public ArrayList<SupplierSite> getAllSupplierSite() throws SQLException, ClassNotFoundException {
	SupplierSite supplierSite;
	ArrayList<SupplierSite> supplierSiteList = new ArrayList<SupplierSite>();
	Connection conn = getConnectioDetails();
	String query = "SELECT  site_id,site_name,site_address,site_location,site_contact from supplier_portal_sites";
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery(query);
	while (rs.next()) {
		supplierSite = new SupplierSite();
		supplierSite.setSiteId(rs.getString("site_id"));
		supplierSite.setSiteName(rs.getString("site_name"));
		supplierSite.setSiteAddress(rs.getString("site_address"));
		supplierSite.setSiteContact(rs.getString("site_contact"));
		supplierSite.setSiteLocation(rs.getString("site_location"));
		supplierSiteList.add(supplierSite);
	}
	logger.info("Modules Name list is: " + supplierSiteList.toString());
	return supplierSiteList;
}

public String updateSupplierSite(SupplierSite supplierSite) throws SQLException, ClassNotFoundException {
	String updateStatus;
	Connection conn = getConnectioDetails();
	String query = "UPDATE SUPPLIER_PORTAL.supplier_portal_sites SET site_address = ?,site_location = ?, site_contact = ?  WHERE site_name = ?  ";
	logger.info(query);
	PreparedStatement pstmt = conn.prepareStatement(query);
	pstmt.setString(1, supplierSite.getSiteAddress());
	pstmt.setString(2, supplierSite.getSiteLocation());
	pstmt.setString(3, supplierSite.getSiteContact());
	pstmt.setString(4, supplierSite.getSiteName());
	int updateStatusCode = pstmt.executeUpdate();
	logger.info(Integer.toString(updateStatusCode));
	updateStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
	pstmt.close();
	return updateStatus;
}

public String deleteSupplierSite(String supplierSiteName) throws ClassNotFoundException, SQLException {
	String deleteStatus;
	Connection conn = getConnectioDetails();
	String query = "DELETE FROM SUPPLIER_PORTAL.supplier_portal_sites WHERE site_name = ?";
	logger.info(query);
	PreparedStatement pstmt = conn.prepareStatement(query);
	pstmt.setString(1, supplierSiteName);
	int updateStatusCode = pstmt.executeUpdate();
	logger.info(Integer.toString(updateStatusCode));
	deleteStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
	pstmt.close();
	return deleteStatus;
}

public String createSupplierSite(SupplierSite supplierSite) throws SQLException, ClassNotFoundException {
	String creationStatus;
	Connection conn = getConnectioDetails();
	String insertQuery = "INSERT INTO SUPPLIER_PORTAL.supplier_portal_sites(site_id, site_name, site_address, site_location, site_contact)"
			+ " VALUES" + "(?, ?, ?, ?, ?)";
	logger.info(insertQuery);
	PreparedStatement pstmt = conn.prepareStatement(insertQuery);
	pstmt.setString(1, umUtils.setRandomUUID());
	pstmt.setString(2, supplierSite.getSiteName());
	pstmt.setString(3, supplierSite.getSiteAddress());
	pstmt.setString(4, supplierSite.getSiteLocation());
	pstmt.setString(5, supplierSite.getSiteContact());
	int updateStatusCode = pstmt.executeUpdate();
	logger.info(Integer.toString(updateStatusCode));
	creationStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
	pstmt.close();
	return creationStatus;
}
}
