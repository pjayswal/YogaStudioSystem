package org.ys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.ys.commons.Customer;

@Controller
public class CustomerController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getRegistrationForm() {

		ModelAndView model = new ModelAndView("RegistrationForm");

		return model;
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView submitRegistrationForm(@ModelAttribute("customer1") Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			
			ModelAndView model = new ModelAndView("RegistrationForm");
			return model;
		}

		ModelAndView model = new ModelAndView("RegistrationSuccess");
		model.addObject("welcomeMessage", "Congratulations!! You are successfully registered to Yoga Studio");

		return model;
	}
}
