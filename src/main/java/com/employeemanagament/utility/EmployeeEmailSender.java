package com.employeemanagament.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEmailSender{
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String email,String subject,String text) {
		SimpleMailMessage sm=new SimpleMailMessage();
		sm.setTo(email);
		sm.setSubject(subject);
		sm.setText(text);
		mailSender.send(sm);
	}
	
}
