package org.ys.services;

import java.awt.Cursor;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.clientservices.IShoppingService;
import org.ys.commons.Address;
import org.ys.commons.Category;
import org.ys.commons.Customer;
import org.ys.commons.Order;
import org.ys.commons.OrderLine;
import org.ys.commons.Payment;
import org.ys.commons.Product;
import org.ys.commons.ShoppingCart;
import org.ys.idao.ICategoryDAO;
import org.ys.idao.ICustomerDAO;
import org.ys.idao.IOrderDAO;
import org.ys.idao.IOrderLineDAO;
import org.ys.idao.IPaymentDAO;
import org.ys.idao.IProductDAO;
import org.ys.idao.IShoppingCartDAO;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class ShoppingService implements IShoppingService{
	
	@Autowired
	private ICustomerDAO customerDAO;
	@Autowired
	private IShoppingCartDAO shoppingCartDAO;
	@Autowired
	private IOrderLineDAO orderLineDAO;
	@Autowired
	private IProductDAO productDAO;
	@Autowired
	private ICategoryDAO categoryDAO;
	@Autowired
	private IOrderDAO orderDAO;
	@Autowired
	private IPaymentDAO paymentDAO;

	public OrderLine getOrderLine(long id) {
		return orderLineDAO.get(id);
	}

	public Customer getCustomer(long id) {
		return customerDAO.get(id);
	}

	public Product getProduct(long id) {
		return productDAO.get(id);
	}
	
	public List<Product> getProducts() {
		return productDAO.getAll();
	}

	public List<Category> 	getCategories(){
		return categoryDAO.getAll();
	}

	public List<Product> getCategoryProducts(Long category_id) {
		return categoryDAO.get(category_id).getProducts();
	}

	public Product getProductDetail(Long product_id) {
		return productDAO.get(product_id);		
	}

	public void addToCart(Customer customer, Long product_id) {
		OrderLine orderLine = new OrderLine(1,getProduct(product_id).getPrice(),getProduct(product_id));
		orderLineDAO.create(orderLine);
		customer.getShoppingCart().addOrderLine(orderLine);
		customerDAO.update(customer);
		//return customer.getShoppingCart().getOrderLines();		
	}

	public void updateCartQuantity(Customer customer, OrderLine orderLine, int quantity) {
		orderLine.setAmount(orderLine.getAmount()/orderLine.getQuantity()*quantity);
		orderLine.setQuantity(quantity);
		orderLineDAO.update(orderLine);
		//return customer.getShoppingCart().getOrderLines();		
	}

	public void removeFromCart(Customer customer, OrderLine orderLine) {
		customer.getShoppingCart().getOrderLines().remove(orderLine);
		shoppingCartDAO.update(customer.getShoppingCart());
		//return customer.getShoppingCart().getOrderLines();	
	}
	
	public List<OrderLine> getCart(Customer customer) {
		return customer.getShoppingCart().getOrderLines();
	}


	public Order checkout(Address shippingAddress, Customer customer) {
		Order order = new Order(new Date(), new Date(), shippingAddress, "Ordered", customer, customer.getShoppingCart());
		orderDAO.create(order);
		return order;		
	}

	public Payment payment(Order order, String details) {
		Payment payment = new Payment(new Date(), order.getTotalAmount(), details, order);
		paymentDAO.create(payment);
		return payment;		
	}

	public ShoppingCart createSC() {
		ShoppingCart cart = new ShoppingCart();
		shoppingCartDAO.create(cart);
		Customer customer = customerDAO.get((long) 98304);
		customer.setShoppingCart(cart);
		customerDAO.update(customer);
		return cart;
	}
}
