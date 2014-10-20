package org.ys.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ys.clientservices.IAdminService;
import org.ys.clientservices.IFacultyService;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Waiver;
import org.ys.services.CustomerService;

@Controller
@RequestMapping(value = "/faculty/")
public class FacultyController {
	@Autowired
	private IFacultyService facultyService;
	@Autowired
	private IAdminService adminService;

	@RequestMapping(value = "/section/")
	public String getTakingSections(Model model, HttpServletRequest request) {
		Faculty faculty = (Faculty) request.getSession()
				.getAttribute("loggedInUser");
		model.addAttribute("sections",
				facultyService.getTakingSections(faculty));
		return "faculty/sectionlist";
	}

	@RequestMapping(value = "/waiver/")
	public String getWaiverRequests(Model model, HttpServletRequest request) {
		Faculty faculty = (Faculty) request.getSession()
				.getAttribute("loggedInUser");
		model.addAttribute("waivers", facultyService.getWaiverRequests(faculty));
		return "faculty/waiverlist";
	}
	
	@RequestMapping(value = "/advisees/")
	public String getAdvisees(Model model, HttpServletRequest request) {
		Faculty faculty = (Faculty) request.getSession()
				.getAttribute("loggedInUser");
		model.addAttribute(faculty);
		model.addAttribute("customers", facultyService.getAdvisees(faculty));
		return "faculty/adviseelist";
	}

	@RequestMapping(value = "/accept/{id}")
	public String acceptWaiver(@PathVariable long id, Model model,
			HttpServletRequest request) {
		Waiver waiver = facultyService.getWaiver(id);
		facultyService.approveWaiver(waiver);
		return "redirect:../waiver/";
	}

	@RequestMapping(value = "/reject/{id}")
	public String rejectWaiver(@PathVariable long id, Model model,
			HttpServletRequest request) {
		Waiver waiver = facultyService.getWaiver(id);
		facultyService.rejectWaiver(waiver);
		return "redirect:../waiver/";
	}
}
