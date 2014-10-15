package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Faculty;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IFacultyDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class FacultyDAO extends GenericHibernateDAO<Faculty, Long> implements IFacultyDAO {

}
