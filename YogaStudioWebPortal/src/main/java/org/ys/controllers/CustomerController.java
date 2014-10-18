package org.ys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ys.clientservices.IAdminService;
import org.ys.clientservices.ICustomerService;
import org.ys.commons.Course;
import org.ys.commons.Customer;
import org.ys.commons.Product;
import org.ys.commons.Section;
import org.ys.commons.Waiver;
import org.ys.helper.SectionDataSet;

@Controller
@RequestMapping(value = "/customer/")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IAdminService adminService;

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
		return "redirect:../../section/";
	}

	@RequestMapping(value = "/section/")
	public String getAvailableSections(Model model) {
		model.addAttribute("sections", adminService.getSections());
		Customer customer = customerService.getCustomer(1);
		List<SectionDataSet> sectionDataSet = customerService
				.getSections(customer);
		model.addAttribute("customer", customer);
		model.addAttribute("sectionDataSets", sectionDataSet);
		return "customer/sectionlist";
	}

	/**
	 * Enroll Section
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/enroll/{id}", method = RequestMethod.GET)
	public String enrollSection(@PathVariable long id, Model model) {
		Customer customer = customerService.getCustomer(1);
		String username = customer.getUser().getUsername();
		Section section = adminService.getSection(id);
		customerService.enrollSection(username, section);
		return "redirect:../section/";
	}

	/**
	 * Withdraw Section
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/withdraw/", method = RequestMethod.GET)
	public String getEnrolledSection(Model model) {
		model.addAttribute("sections", customerService.getCustomer(1)
				.getEnrolledSections());
		return "customer/withdrawlist";
	}

	@RequestMapping(value = "/withdraw/{id}", method = RequestMethod.GET)
	public String withdrawSection(@PathVariable long id, Model model) {
		Customer customer = customerService.getCustomer(1);
		String username = customer.getUser().getUsername();
		Section section = adminService.getSection(id);
		customerService.withdrawSection(username, section);
		return "redirect:../withdraw/";
	}

	/**
	 * Waive Section
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/waiver/{id}", method = RequestMethod.GET)
	public String waiveSectionList(@PathVariable long id, Model model) {
		Section section = adminService.getSection(id);
		Customer customer=customerService.getCustomer(1);
		SectionDataSet sectionDataSet=new SectionDataSet(customer, section);
		List<Course> courses=sectionDataSet.getUnfullfilledPrerequisites();
		//model.addAttribute(sectionDataSet);
		model.addAttribute("waiver", new Waiver());
		model.addAttribute(section);
		model.addAttribute("courses", courses);
		//model.addAttribute("waiver", new Waiver());
		return "customer/waiverlist";
	}

	/**
	 * 
	 * @param waiver
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/waiver/add", method = RequestMethod.POST)
	public String createWaiver(@ModelAttribute("waiver") Waiver waiver,
			BindingResult result) {
		Customer customer = customerService.getCustomer(1);
		String username = customer.getUser().getUsername();
		customerService.addWaiverRequest(username, waiver);
		return "redirect:../section/";
	}
}