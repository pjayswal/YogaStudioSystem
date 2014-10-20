package org.ys.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.ys.clientservices.IAdminService;
import org.ys.clientservices.IEmailService;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Role;

@Controller
public class LoginController {
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IEmailService emailService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String redirectToSpecificController(Model m,HttpServletRequest request){
		User  user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username =user.getUsername();
		if(request.isUserInRole(Role.ROLE_CUSTOMER)){
			Customer customer = adminService.getCustomer(username);
		request.getSession().setAttribute("loggedInUser", customer);
			return "redirect:/customer/home";
		}
		else if(request.isUserInRole(Role.ROLE_ADMIN)){
			return "redirect:/admin/home/";
		}
		else if(request.isUserInRole(Role.ROLE_FACULTY)){ 
			Faculty faculty = adminService.getFaculty(username);
			request.setAttribute("loggedInUser", faculty);
			return "redirect:/faculty/home";
		}
		else
			return "redirect:/home.html";
		
	}
	@RequestMapping(value = "/activate", method = RequestMethod.GET)
	public String activateCustomer(Model model, @RequestParam("id") String id) {
		emailService.enableUser(id);
		return "redirect:/login.jsp";
	}

}
