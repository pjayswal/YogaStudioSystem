package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Person;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IPersonDAO;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class PersonDAO extends GenericHibernateDAO<Person, Long> implements IPersonDAO{

}
