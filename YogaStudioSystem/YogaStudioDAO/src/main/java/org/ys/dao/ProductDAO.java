package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.ys.commons.Product;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IProductDAO;
@Repository
public class ProductDAO extends GenericHibernateDAO<Product, Long> implements IProductDAO{

}
