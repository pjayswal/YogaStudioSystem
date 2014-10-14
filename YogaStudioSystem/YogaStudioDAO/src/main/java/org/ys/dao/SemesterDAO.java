package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.ys.commons.Semester;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.ISemesterDAO;
@Repository
public class SemesterDAO extends GenericHibernateDAO<Semester, Long> implements ISemesterDAO{

}
