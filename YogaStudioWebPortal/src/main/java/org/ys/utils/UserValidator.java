package org.ys.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.ys.clientservices.IAdminService;
import org.ys.commons.UserCredential;
@Component
public class UserValidator implements Validator {
	private IAdminService adminService;
	
	public UserValidator() {
		// TODO Auto-generated constructor stub
	}
	public UserValidator(IAdminService adminService) {
		this.adminService = adminService;
	}
	public boolean supports(Class<?> clazz) {
		return UserCredential.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		UserCredential user = (UserCredential) target;
		if(user.getUsername()!= null) {
			if(adminService.getUser(user.getUsername())!=null)
				errors.rejectValue("user.username", "username.not.unique");
		}
	}


}