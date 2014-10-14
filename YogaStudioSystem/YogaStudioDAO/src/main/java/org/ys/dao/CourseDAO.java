package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.ys.commons.Course;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.ICourseDAO;
@Repository
public class CourseDAO extends GenericHibernateDAO<Course, Long> implements ICourseDAO{

}
