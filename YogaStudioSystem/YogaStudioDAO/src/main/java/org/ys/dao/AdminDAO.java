package org.ys.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Admin;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IAdminDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class AdminDAO extends GenericHibernateDAO<Admin, Long> implements IAdminDAO{

	public Admin getAdmin(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM Admin a WHERE a.user.username=:uname");
		query.setParameter("uname", username);
		@SuppressWarnings("unchecked")
		List<Admin> admins = query.list();
		return admins.get(0);
	}

}
