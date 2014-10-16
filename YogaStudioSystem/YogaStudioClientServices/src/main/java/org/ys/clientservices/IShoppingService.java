package org.ys.clientservices;

import java.util.Date;
import java.util.List;

import org.ys.commons.Address;
import org.ys.commons.Customer;
import org.ys.commons.ShoppingCart;
import org.ys.commons.OrderLine;
import org.ys.commons.Product;
import org.ys.commons.Category;
import org.ys.commons.Order;
import org.ys.commons.Payment;
	
public interface IShoppingService {

	public List<Product> 	getProducts();
	public List<Product> 	getCategoryProducts(Long category_id);
	public Product 		 	getProductDetails(Long product_id);
	public List<OrderLine> 	addToCart(Customer customer, Long product_id);
	public List<OrderLine> 	updateCartQuantity(Customer customer, OrderLine orderLine, int quantity);
	public List<OrderLine> 	removeFromCart(Customer customer, OrderLine orderLine);
	public List<OrderLine> 	getCart(Customer customer);
	public Order 		 	checkout(Address shippingAddress, Customer customer);
	public Payment 		 	payment(Order order, String details);
	
}
