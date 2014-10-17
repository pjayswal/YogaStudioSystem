package org.ys.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Faculty;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IFacultyDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class FacultyDAO extends GenericHibernateDAO<Faculty, Long> implements IFacultyDAO {

	public Faculty getFaculty(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM Faculty f WHERE f.user.username=:uname");
		query.setParameter("uname", username);
		@SuppressWarnings("unchecked")
		List<Faculty> faculties = query.list();
		return faculties.get(0);
	}

}
