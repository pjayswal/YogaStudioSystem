package org.ys.controllers;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ys.clientservices.IAdminService;
import org.ys.commons.Admin;
import org.ys.commons.Role;
import org.ys.commons.UserCredential;

@Controller
public class LoginController {
	@Autowired
	private IAdminService adminService;
	@PostConstruct
	private void init() {
		Role admin = new Role("ROLE_ADMIN");
		adminService.addRole(admin);
		UserCredential uadmin = new UserCredential("admin", "admin");
		Admin administrator = new Admin("admin", "admin@yogastudio.com", "01-8974567893", new Date(), uadmin);
		adminService.addAdmin(administrator);
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String redirectToSpecificController(Model m,HttpServletRequest request){
		User  user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username =user.getUsername();
		if(username=="admin"){
			System.out.println("Admin logged");
			return "redirect:/home.html";
		}
		else
			return "redirect:/loginerror.html";
		
	}

}
