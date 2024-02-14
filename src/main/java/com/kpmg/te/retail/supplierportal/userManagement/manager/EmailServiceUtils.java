
package com.kpmg.te.retail.supplierportal.userManagement.manager;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kpmg.te.retail.supplierportal.userManagement.dao.SupplierPortalUserManagementDao;

@Component
@CrossOrigin
public class EmailServiceUtils {

	@Autowired
	private JavaMailSender javaMailSender;

	SupplierPortalUserManagementDao umDao = new SupplierPortalUserManagementDao();

	@Value("${spring.mail.username}")
	private String sender;

	private static final Logger logger = Logger.getLogger(EmailServiceUtils.class.getName());



	public String sendEmail(String userEmail, String userId, String randomPwd) {
		try {
			logger.info("[C]:EmailServiceUtils - " + userEmail.toString());
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(userEmail);
			mailMessage.setText("Welcome to Supplier Portal. Your login id is  :-" + userId + " and your first time login password is : "+ randomPwd);
			logger.info("[C]:EmailServiceUtils - mailmessage " + mailMessage.toString());
			javaMailSender.send(mailMessage);

			return "Mail Sent Successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error while Sending Mail";
		}
	}

	

}
