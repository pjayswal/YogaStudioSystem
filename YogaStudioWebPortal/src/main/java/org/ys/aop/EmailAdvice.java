package org.ys.aop;

import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ys.clientservices.IEmailService;
import org.ys.commons.Customer;
import org.ys.commons.Registration;
import org.ys.utils.DataDefinition;

@Component
@Aspect
public class EmailAdvice {
	@Autowired
	private IEmailService yogaEmailService;
	@After("execution(* org.ys.services.CustomerService.addCustomer(..)) && args(customer)")
	//@Before("execution(* org.ys.services.AdminService.*(..))")
	public void validateRegistrationViaEmail(JoinPoint joinPoint,Customer customer){
		String email =customer.getEmail();
		String name = customer.getName();
		UUID registrationID = UUID.randomUUID();
		String activationURL= DataDefinition.INDEX+"activate?id="+registrationID;
		String content = "Please click on this link to activate your account:\n"+activationURL;
		yogaEmailService.sendMail(name, content, new String[]{email});
		yogaEmailService.addRegistration(new Registration(registrationID, customer.getUser()));
		System.out.println("Email Sender");
	}
}
