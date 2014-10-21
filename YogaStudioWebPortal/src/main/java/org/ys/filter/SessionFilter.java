package org.ys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.ys.clientservices.IAdminService;
import org.ys.commons.Admin;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Role;
import org.ys.commons.ShoppingCart;
import org.ys.services.AdminService;

public class SessionFilter implements Filter {
	
	private IAdminService adminService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(filterConfig.getServletContext());
		adminService = context.getBean(AdminService.class);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Inside filter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if (httpRequest.getSession().getAttribute("loggedUser") == null) {
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) ((HttpServletRequest) request)
					.getUserPrincipal();
			if (token != null) {
				User user = (User)token.getPrincipal();
				String username = user.getUsername();
				
				if (httpRequest.isUserInRole(Role.ROLE_CUSTOMER)) {
					Customer customer = adminService.getCustomer(username);
					httpRequest.getSession().setAttribute("loggedInUser",
							customer);
				} else if (httpRequest.isUserInRole(Role.ROLE_ADMIN)) {
					Admin admin = adminService.getAdmin(username);
					httpRequest.getSession()
							.setAttribute("loggedInUser", admin);
				} else if (httpRequest.isUserInRole(Role.ROLE_FACULTY)) {
					Faculty faculty = adminService.getFaculty(username);
					httpRequest.getSession().setAttribute("loggedInUser",
							faculty);
				}
				
			}
			else{
				Customer customer = new Customer();
				customer.setShoppingCart(new ShoppingCart());
				httpRequest.getSession().setAttribute("loggedInUser",
						customer);
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}