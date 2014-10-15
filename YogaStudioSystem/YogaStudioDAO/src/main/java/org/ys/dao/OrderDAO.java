package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Order;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IOrderDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class OrderDAO extends GenericHibernateDAO<Order, Long> implements IOrderDAO{

}
