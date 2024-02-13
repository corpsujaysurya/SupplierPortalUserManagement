package com.kpmg.te.retail.supplierportal.userManagement.utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class UserManagementUtils {
	
	public  String setRandomUUID() {
		return UUID.randomUUID().toString();
	}
	
	public String generateUserId() {
		String userId = "USR-";
	    Random r = new Random(System.currentTimeMillis());
	     return userId.concat(Integer.toString(((1 + r.nextInt(3)) * 100000 + r.nextInt(10000))));
	}

	public String generateRandomPwd() {
		char[] possibleCharacters = (new String(
				"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?"))
				.toCharArray();
		String randomStr = RandomStringUtils.random(10, 0, possibleCharacters.length - 1, false, false,
				possibleCharacters, new SecureRandom());
		return randomStr;
	}


}
