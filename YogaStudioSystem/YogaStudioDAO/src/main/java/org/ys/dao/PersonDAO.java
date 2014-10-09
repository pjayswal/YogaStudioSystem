package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.ys.commons.Person;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IPersonDAO;

@Repository
public class PersonDAO extends GenericHibernateDAO<Person, Long> implements IPersonDAO{

}
