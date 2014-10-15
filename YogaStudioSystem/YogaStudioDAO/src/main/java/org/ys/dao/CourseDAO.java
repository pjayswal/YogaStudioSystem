package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Course;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.ICourseDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class CourseDAO extends GenericHibernateDAO<Course, Long> implements ICourseDAO{

}
