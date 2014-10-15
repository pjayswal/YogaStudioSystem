package org.ys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.ys.clientservices.IAdminService;
import org.ys.commons.Course;
import org.ys.commons.Faculty;
import org.ys.commons.Semester;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;

	
	
	@RequestMapping(value = "/semester", method = RequestMethod.GET)
	public String viewSemesters(Model model) {
		List<Semester> semesters = adminService.getSemesters(); 
		model.addAttribute("semesters",semesters);
		return "admin/listsemester";
	}
	

	@RequestMapping(value = "/addCourseSubmit", method = RequestMethod.POST)
	public ModelAndView submitCourseForm(
			@ModelAttribute("course1") Course course, BindingResult result) {
		if (result.hasErrors()) {

			ModelAndView model = new ModelAndView("AddCourse");
			return model;
		}

		ModelAndView model = new ModelAndView("AddCourseSuccess");
		model.addObject("welcomeMessage", "Course Successfully Added");

		return model;
	}
	
	@RequestMapping(value = "/addsemester", method = RequestMethod.GET)
	public ModelAndView getSemesterForm() {

		ModelAndView model = new ModelAndView("AddSemester");

		return model;
	}

	@RequestMapping(value = "/addSemesterSubmit", method = RequestMethod.POST)
	public ModelAndView submitSemesterForm(
			@ModelAttribute("semester1") Semester semester, BindingResult result) {
		if (result.hasErrors()) {

			ModelAndView model = new ModelAndView("AddSemester");
			return model;
		}

		ModelAndView model = new ModelAndView("AddSemesterSuccess");
		model.addObject("welcomeMessage", "Semester Successfully Added");

		return model;
	}
	
	@RequestMapping(value = "/addfaculty", method = RequestMethod.GET)
	public ModelAndView getFacultyForm() {

		ModelAndView model = new ModelAndView("AddFaculty");

		return model;
	}

	@RequestMapping(value = "/addFacultySubmit", method = RequestMethod.POST)
	public ModelAndView submitFacultyForm(
			@ModelAttribute("faculty1") Faculty faculty, BindingResult result) {
		if (result.hasErrors()) {

			ModelAndView model = new ModelAndView("AddFaculty");
			return model;
		}

		ModelAndView model = new ModelAndView("AddFacultySuccess");
		model.addObject("welcomeMessage", "Faculty Successfully Added");

		return model;
	}

}
