package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Category;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.ICategoryDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class CategoryDAO extends GenericHibernateDAO<Category, Long> implements ICategoryDAO{

}
