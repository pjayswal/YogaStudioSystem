package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Order;
import org.ys.commons.ShoppingCart;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IShoppingCartDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class ShoppingCartDAO extends GenericHibernateDAO<ShoppingCart, Long> implements IShoppingCartDAO{

}
