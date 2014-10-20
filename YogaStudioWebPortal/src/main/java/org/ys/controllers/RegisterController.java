package org.ys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ys.clientservices.ICustomerService;
import org.ys.commons.Customer;
@Controller
public class RegisterController {
	@Autowired
	private ICustomerService customerService;
	
	/**
	 * get Registration form
	 *
	 * @param model
	 * @return form for adding customer
	 */
	@RequestMapping(value = "/register/", method = RequestMethod.GET)
	public String getRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/registration";
	}

	/**
	 *
	 * @param customer
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/register/submit", method = RequestMethod.POST)
	public String createorUpdateCustomer(Model model,
			@ModelAttribute("customer") Customer customer, BindingResult result) {
		customerService.addCustomer(customer);
		return "registersuccess";
	}


}
