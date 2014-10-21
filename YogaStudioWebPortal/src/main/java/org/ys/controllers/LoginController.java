package org.ys.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.ys.clientservices.IAdminService;
import org.ys.clientservices.IEmailService;
import org.ys.commons.Role;

@Controller
public class LoginController {
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value="/login")
	private String getLoginForm() {
		return "login";
	}
	
	@RequestMapping(value="/processlogin",method=RequestMethod.GET)
	public String redirectToSpecificController(Model m,HttpServletRequest request){
		if(request.isUserInRole(Role.ROLE_CUSTOMER)){
			return "redirect:/customer/home";
		}
		else if(request.isUserInRole(Role.ROLE_ADMIN)){
			return "redirect:/admin/";
		}
		else if(request.isUserInRole(Role.ROLE_FACULTY)){ 
			return "redirect:/faculty/home";
		}
		else
			return "redirect:/";
		
	}
	
	
}
