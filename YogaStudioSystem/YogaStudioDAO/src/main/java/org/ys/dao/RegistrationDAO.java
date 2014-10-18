package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Registration;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IRegistrationDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class RegistrationDAO extends GenericHibernateDAO<Registration, String> implements IRegistrationDAO {

}
