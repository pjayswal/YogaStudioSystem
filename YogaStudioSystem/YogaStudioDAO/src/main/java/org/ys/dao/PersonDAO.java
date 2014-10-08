package org.ys.dao;

import org.ys.commons.Person;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IPersonDAO;

public class PersonDAO extends GenericHibernateDAO<Person, Long> implements IPersonDAO{

}
