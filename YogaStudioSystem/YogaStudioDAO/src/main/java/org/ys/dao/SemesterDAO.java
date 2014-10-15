package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Semester;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.ISemesterDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class SemesterDAO extends GenericHibernateDAO<Semester, Long> implements ISemesterDAO{

}
