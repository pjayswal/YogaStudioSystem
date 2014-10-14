package org.ys.dao;

import org.ys.commons.Order;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IOrderDAO;

public class OrderDAO extends GenericHibernateDAO<Order, Long> implements IOrderDAO{

}
