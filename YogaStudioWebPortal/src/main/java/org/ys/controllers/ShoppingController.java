package org.ys.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ys.clientservices.IShoppingService;
import org.ys.commons.Category;
import org.ys.commons.Customer;
import org.ys.commons.Order;
import org.ys.commons.OrderLine;
import org.ys.commons.Payment;
import org.ys.commons.Product;
import org.ys.commons.Semester;
import org.ys.commons.ShoppingCart;
/**
 * to handle shopping requests
 * @author Amara
 */
@Controller
@RequestMapping(value="/shop/")
public class ShoppingController {
	@Autowired
	private IShoppingService shoppingService;
	
	@RequestMapping(value="/")
	public String home(Model model,HttpServletRequest request){
		//shoppingService.createSC();
		List<Category> categories = shoppingService.getCategories();
		List<Product> products = shoppingService.getProducts();
		Customer customer = (Customer) request.getSession().getAttribute("loggedInUser");
		List<OrderLine> orderLines = shoppingService.getCart(customer);
		model.addAttribute("categories", categories);
		model.addAttribute("products", products);
		model.addAttribute("orderLines", orderLines);
		return "shop/index";
	}
	/**
	 * category products
	 * @param model
	 * @return the list of products in the category
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String faculties(@PathVariable long id, Model model,HttpServletRequest request) {
		List<Category> categories = shoppingService.getCategories();
		List<Product> products = shoppingService.getCategoryProducts(id);
		Customer customer = (Customer) request.getSession().getAttribute("loggedInUser");
		List<OrderLine> orderLines = shoppingService.getCart(customer);
		model.addAttribute("orderLines", orderLines);
		model.addAttribute("categories", categories);
		model.addAttribute("products", products);
		model.addAttribute("catid", id);
		return "shop/category";
	}
	/**
	* product detail
	* @param id
	* @param model
	* @return
	*/
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String productDetail(@PathVariable long id, Model model,HttpServletRequest request) {
		List<Category> categories = shoppingService.getCategories();
		Product product = shoppingService.getProductDetail(id);
		Customer customer = (Customer) request.getSession().getAttribute("loggedInUser");
		List<OrderLine> orderLines = shoppingService.getCart(customer);
		model.addAttribute("orderLines", orderLines);
		model.addAttribute("categories", categories);
		model.addAttribute("product", product);
		model.addAttribute("catid", product.getCategory().getId());
		return "shop/product";
	}
	/**
	 * @param model
	 * @return form 
	 */
	@RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
	public String cartAdd(@PathVariable long id,HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute("loggedInUser");
		boolean productInCart = false;
		for(OrderLine orderLine: customer.getShoppingCart().getOrderLines()){
			if(orderLine.getProduct().getId()==id){
				shoppingService.updateCartQuantity(customer, orderLine, orderLine.getQuantity()+1);
				productInCart = true;
				break;
			}
		}			
		if (!productInCart) shoppingService.addToCart(customer, id);
		return "redirect:../cart/";
	}
	@RequestMapping(value="/cart/", method = RequestMethod.GET)
	public String cart(Model model,HttpServletRequest request){
		//shoppingService.createSC();
		List<Category> categories = shoppingService.getCategories();
		Customer customer = (Customer) request.getSession().getAttribute(
				"loggedInUser");
		List<OrderLine> orderLines = shoppingService.getCart(customer);
		model.addAttribute("categories", categories);
		model.addAttribute("orderLines", orderLines);
		return "shop/cart";
	}
	/**
	 * @param model
	 * @return form 
	 */
	@RequestMapping(value = "/cart/", method = RequestMethod.POST)
	public String cartUpdate(Model model, @Valid int id,int quantity,HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute(
				"loggedInUser");
		OrderLine orderLine = shoppingService.getOrderLine(id);
		if (quantity==0) shoppingService.removeFromCart(customer, orderLine);
		else  shoppingService.updateCartQuantity(customer, orderLine, quantity);
		return "redirect:../cart/";
	}
	
	/**
	 * @param model
	 * @return form 
	 */
	@RequestMapping(value = "/cart/remove/{id}", method = RequestMethod.GET)
	public String cartRemove(@PathVariable long id,HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute(
				"loggedInUser");
		for(OrderLine orderLine: customer.getShoppingCart().getOrderLines()){
			if(orderLine.getProduct().getId()==id){
				shoppingService.removeFromCart(customer, orderLine);
				break;
			}
		}	
		return "redirect:../";
	}
	/**
	 * 
	 * @param faculty
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/checkout/", method = RequestMethod.GET)
	public String checkout(Model model,HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute("loggedInUser");
		model.addAttribute("customer", customer);
		model.addAttribute("order",new Order());
		return "shop/checkout";
	}
	/**
	 * 
	 * @param faculty
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/pay/", method = RequestMethod.POST)
	public String pay(Model model, @Valid @ModelAttribute("order") Order order, String pmtmthd,HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute("loggedInUser");
		order = shoppingService.checkout(order, customer);
		Payment payment = shoppingService.payment(order, pmtmthd);

		model.addAttribute("customer", customer);
		model.addAttribute("order",order);
		model.addAttribute("payment",pmtmthd);
		return "shop/success";
	}
}
