package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.ys.commons.Faculty;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IFacultyDAO;
@Repository
public class FacultyDAO extends GenericHibernateDAO<Faculty, Long> implements IFacultyDAO {

}
