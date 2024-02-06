package com.kpmg.te.retail.supplierportal.userManagement.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UserManagementUtils {
	
	public  String setRandomUUID() {
		return UUID.randomUUID().toString();
	}


}
