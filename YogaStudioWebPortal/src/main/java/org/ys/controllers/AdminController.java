package org.ys.controllers;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.ys.clientservices.IAdminService;
import org.ys.commons.Category;
import org.ys.commons.Course;
import org.ys.commons.Faculty;
import org.ys.commons.Product;
import org.ys.commons.Section;
import org.ys.commons.Semester;

@Controller
@RequestMapping(value="/admin/")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value="/")
	public String home(){
		return "admin/index";
	}
	
	/**
	 * 
	 * @param model
	 * @return the list of semester in the system
	 */
	@RequestMapping(value = "/semester/", method = RequestMethod.GET)
	public String listSemesters(Model model) {
		List<Semester> semesters = adminService.getSemesters(); 
		model.addAttribute("semesters",semesters);
		return "admin/semesterlist";
	}
	/**
	 * get Semester from 
	 * @param model
	 * @return form for adding semester
	 */
	@RequestMapping(value = "/semester/add", method = RequestMethod.GET)
	public String getSemesterForm(Model model) {
		model.addAttribute("semester", new Semester());
		return "admin/semesteradd";
	}
	/**
	 * 
	 * @param semester
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/semester/add", method = RequestMethod.POST)
	public String createorUpdateSemeter(@Valid @ModelAttribute("semester") Semester semester,
			BindingResult result) {
		if(result.hasErrors()){
			return "admin/semesteradd";
		}
		adminService.addSemester(semester);
		return "redirect:./";
	}
	/**
	 * semester details with section list
	 * @param id
	 * @param model
	 * @return 
	 */

	@RequestMapping(value = "/semester/{id}", method = RequestMethod.GET)
	public String getSemesterDetails(@PathVariable long id, Model model) {
		Semester semester = adminService.getSemester(id);
		model.addAttribute("semester", semester);
		return "admin/semesterdetails";
	}
	
	/**
	 * 
	 * @param model
	 * @return the list of course in the system
	 */
	@RequestMapping(value = "/course/", method = RequestMethod.GET)
	public String listCourses(Model model) {
		model.addAttribute("courses",adminService.getCourses());
		return "admin/courselist";
	}
	/**
	 * get Course from 
	 * @param model
	 * @return form for adding course
	 */
	@RequestMapping(value = "/course/add", method = RequestMethod.GET)
	public String getCourseForm(Model model) {
		model.addAttribute("course", new Course());
		model.addAttribute("prerequisites", adminService.getCourses());
		return "admin/courseadd";
	}
	/**
	 * 
	 * @param course
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/course/add", method = RequestMethod.POST)
	public String createorUpdateCourse(Model model,
			@Valid @ModelAttribute("course") Course course,
			BindingResult result) {
		if(result.hasErrors()){
			if(course.getId()!=0){
				model.addAttribute("prerequisites", adminService.getCourses());
				return "admin/courseupdate";
			}
			else{
				model.addAttribute("prerequisites", adminService.getCourses());
				return "admin/courseadd";
			}
		}
		adminService.addCourse(course);
		return "redirect:./";
	}
	/**
	 * semester details with section list
	 * @param id
	 * @param model
	 * @return 
	 */

	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
	public String getCourseDetails(@PathVariable long id, Model model) {
		Course course= adminService.getCourse(id);
		model.addAttribute("course", course);
		model.addAttribute("prerequisites", adminService.getPrerequsiteCandidates(course));
		return "admin/courseupdate";
	}


	
	/* Faculty related request mapping */
	/**
	 * 
	 * @param model
	 * @return the list of faculty in the system
	 */
	@RequestMapping(value = "/faculty/", method = RequestMethod.GET)
	public String faculties(Model model) {
		List<Faculty> faculties = adminService.getFaculties(); 
		model.addAttribute("faculties",faculties);
		return "admin/facultylist";
	}
	/**
	 * 
	 * @param model
	 * @return form for adding faculty
	 */
	@RequestMapping(value = "/faculty/add", method = RequestMethod.GET)
	public String facultyAdd(Model model) {
		model.addAttribute("faculty", new Faculty());
		return "admin/facultyadd";
	}
	/**
	 * 
	 * @param faculty
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/faculty/add", method = RequestMethod.POST)
	public String createOrUpdateFaculty(@Valid @ModelAttribute("faculty") Faculty faculty,
			BindingResult result) {
		if(result.hasErrors()){
			if(faculty.getId()!=0)
				return "admin/facultyadd";
			else
				return "admin/facultyupdate";
		}
		adminService.addFaculty(faculty);
		return "redirect:./";
	}
	/**
	* faculty update
	* @param id
	* @param model
	* @return
	*/
	@RequestMapping(value = "/faculty/{id}", method = RequestMethod.GET)
	public String facultyUpdate(@PathVariable long id, Model model) {
		Faculty faculty = adminService.getFaculty(id);
		model.addAttribute("faculty", faculty);
		return "admin/facultyupdate";
	}

	@RequestMapping(value = "/section/", method = RequestMethod.GET)
	public String listSections(Model model, @RequestParam("semester_id") String id) {
		Semester semester = adminService.getSemester(Long.parseLong(id));
		model.addAttribute("semester", semester);
		model.addAttribute("sections", semester.getSections());
		return "admin/sectionlist";
	}
	
	/**
	 * get Course from 
	 * @param model
	 * @return form for adding course
	 */
	@RequestMapping(value = "/section/add", method = RequestMethod.GET)
	public String getSectionForm(Model model,@RequestParam("semester_id") String id) {
		model.addAttribute("section", new Section());
		model.addAttribute("faculties",adminService.getFaculties());
		model.addAttribute("courses",adminService.getCourses());
		model.addAttribute("semester", adminService.getSemester(Long.parseLong(id)));
		return "admin/sectionadd";
	}
	/**
	 * 
	 * @param course
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/section/add", method = RequestMethod.POST)
	public String createorUpdateSection(@Valid @ModelAttribute("section") Section section,
			@RequestParam("semester_id") String id,
			BindingResult result) {
		if(result.hasErrors()){
			return "admin/sectionadd";
		}
		adminService.addSection(section);
		return "redirect:./?semester_id="+id;
	}
	/**
	 * semester details with section list
	 * @param id
	 * @param model
	 * @return 
	 */

	@RequestMapping(value = "/section/{id}", method = RequestMethod.GET)
	public String getSectionDetails(@PathVariable long id, Model model) {
		model.addAttribute("faculties",adminService.getFaculties());
		model.addAttribute("courses",adminService.getCourses());
		model.addAttribute("section", adminService.getSection(id));
		return "admin/sectionupdate";
	}
	
	/**
	 * 
	 * @param model
	 * @return the list of category in the system
	 */
	@RequestMapping(value = "/category/", method = RequestMethod.GET)
	public String listCategory(Model model) {
		List<Category> categories = adminService.getCategories();
		model.addAttribute("categories", categories);
		return "admin/categorylist";
	}

	/**
	 * get Category from
	 * 
	 * @param model
	 * @return form for adding category
	 */
	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public String getCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		return "admin/categoryadd";
	}

	/**
	 * 
	 * @param category
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String createorUpdateCategory(@Valid	@ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()){
			return "admin/categoryadd";
		}
		adminService.addCategory(category);
		return "redirect:./";
	}

	/**
	 * category details with product list
	 * 
	 * @param id
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public String getCategoryUpdate(@PathVariable long id, Model model) {
		Category category = adminService.getCategory(id);
		model.addAttribute("category", category);
		return "admin/categoryupdate";
	}

	/**
	 * 
	 * @param model
	 * @return the list of products in the system
	 */
	@RequestMapping(value = "/product/", method = RequestMethod.GET)
	public String listProducts(Model model,
			@RequestParam("category_id") String id) {
		Category category = adminService.getCategory(Long.parseLong(id));
		model.addAttribute("category", category);
		model.addAttribute("products", category.getProducts());
		return "admin/productlist";
	}

	/**
	 * get product from
	 * 
	 * @param model
	 * @return form for adding product
	 */
	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public String getProductForm(Model model, @RequestParam("category_id") String id) {
		model.addAttribute("category", adminService.getCategory(Long.parseLong(id)));
		model.addAttribute("product", new Product());
		return "admin/productadd";
	}

	/**
	 * 
	 * @param product
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String createorUpdateProducts(Model model,
			@RequestParam("category_id") String id,
			@Valid @ModelAttribute("product") Product product,BindingResult result) {
		if(result.hasErrors()){
			if(product.getId()==0){
				model.addAttribute("category", adminService.getCategory(Long.parseLong(id)));
				return "admin/productadd";
			}
			else {
				return "admin/productupdate";
				
			}
				
		}
		Category category = adminService.getCategory(Long.parseLong(id));
		model.addAttribute("category", category);
		product.setCategory(category);
		adminService.addProduct(product);
		return "redirect:./?category_id="+id;
	}

	/**
	 * get product edit form
	 * 
	 * @param id
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String getProductUpdate(@PathVariable long id, Model model) {
		Product product = adminService.getProduct(id);
		model.addAttribute("product", product);
		return "admin/productupdate";
	}


	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		binder.registerCustomEditor(Integer.class, "totalSeat",
				new PropertyEditorSupport() {

					@Override
					public void setAsText(String text) {
						Integer totalSeat= Integer.parseInt(text);
						setValue(totalSeat);
					}
				});
		
		binder.registerCustomEditor(Long.class, "id",
				new PropertyEditorSupport() {

					@Override
					public void setAsText(String text) {
						Long id= Long.parseLong(text);
						setValue(id);
					}
				});

		
		
	binder.registerCustomEditor(List.class, "prerequisites",
			new CustomCollectionEditor(List.class) {
				@Override
				protected Object convertElement(Object element) {
					Long id = null;
					if (element instanceof String
							&& !((String) element).equals("")) {
						// From the JSP 'element' will be a String
						try {
							id = Long.parseLong((String) element);
						} catch (NumberFormatException e) {
							System.out.println("Element was "
									+ ((String) element));
							e.printStackTrace();
						}
					} else if (element instanceof Long) {
						// From the database 'element' will be a Long
						id = (Long) element;
					}
					return id != null ? adminService.getCourse(id)
							: null;
				}
			});
	binder.registerCustomEditor(Faculty.class, "faculty",
			new PropertyEditorSupport() {

				@Override
				public void setAsText(String id) {
					Faculty faculty = adminService.getFaculty((Long
							.parseLong(id)));
					setValue(faculty);
				}
			});
	
	binder.registerCustomEditor(Course.class, "course",
			new PropertyEditorSupport() {

				@Override
				public void setAsText(String id) {
					Course course = adminService.getCourse((Long
							.parseLong(id)));
					setValue(course);
				}
			});
	}

}
