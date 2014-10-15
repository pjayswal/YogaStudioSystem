package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Admin;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IAdminDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class AdminDAO extends GenericHibernateDAO<Admin, Long> implements IAdminDAO{

}
