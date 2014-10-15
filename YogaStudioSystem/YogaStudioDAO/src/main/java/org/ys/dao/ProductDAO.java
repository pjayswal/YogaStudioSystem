package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Product;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IProductDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class ProductDAO extends GenericHibernateDAO<Product, Long> implements IProductDAO{

}
