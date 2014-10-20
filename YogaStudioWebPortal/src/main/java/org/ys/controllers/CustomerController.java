package org.ys.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/home")
	public String getHomePage(Model model, HttpServletRequest request) {
		return "customer/home";
	}

	@RequestMapping(value = "/section/")
	public String getAvailableSections(Model model, HttpServletRequest request) {
		model.addAttribute("sections", adminService.getSections());
		Customer customer = (Customer) request.getSession().getAttribute(
				"loggedInUser");
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
	public String enrollSection(@PathVariable long id, Model model,
			HttpServletRequest request) {

		Customer customer = (Customer) request.getSession().getAttribute(
				"loggedInUser");
		Section section = adminService.getSection(id);
		customerService.enrollSection(customer, section);
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
	public String getEnrolledSection(Model model, HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute(
				"loggedInUser");
		model.addAttribute("sections", customer.getEnrolledSections());
		return "customer/withdrawlist";
	}

	@RequestMapping(value = "/withdraw/{id}", method = RequestMethod.GET)
	public String withdrawSection(@PathVariable long id, Model model,
			HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute(
				"loggedInUser");
		Section section = adminService.getSection(id);
		customerService.withdrawSection(customer, section);
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
	public String waiveSectionList(@PathVariable long id, Model model,
			HttpServletRequest request) {
		Section section = adminService.getSection(id);
		Customer customer = (Customer) request.getSession().getAttribute(
				"loggedInUser");
		SectionDataSet sectionDataSet = new SectionDataSet(customer, section);
		List<Course> courses = sectionDataSet.getUnfullfilledPrerequisites();
		// model.addAttribute(sectionDataSet);
		model.addAttribute("waiver", new Waiver());
		model.addAttribute(section);
		model.addAttribute("courses", courses);
		// model.addAttribute("waiver", new Waiver());
		return "customer/waiverlist";
	}

	/**
	 * get waiver form
	 *
	 * @param model
	 * @return form for adding customer
	 */
	@RequestMapping(value = "/waiverform/{id}", method = RequestMethod.GET)
	public String getWaiverForm(@PathVariable long id, Model model) {
		Course course = adminService.getCourse(id);
		model.addAttribute(course);
		model.addAttribute("waiver", new Waiver());
		return "customer/waiver";
	}

	/**
	 * 
	 * @param waiver
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/waiverform/add", method = RequestMethod.POST)
	public String createWaiver(@ModelAttribute("waiver") Waiver waiver,
			BindingResult result, HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute(
				"loggedInUser");
		customerService.addWaiverRequest(customer, waiver);
		return "redirect:../section/";
	}
}