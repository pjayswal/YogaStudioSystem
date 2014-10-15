package org.ys.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public void redirectToSpecificController(Model m,HttpServletRequest request){
		//init();
		User  user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username =user.getUsername();
		if(username=="admin"){
			System.out.println("Admin logged");
		}
	}

}
