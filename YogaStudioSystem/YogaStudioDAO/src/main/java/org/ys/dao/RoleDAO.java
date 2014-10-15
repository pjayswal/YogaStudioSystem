package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Role;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IRoleDAO;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class RoleDAO extends GenericHibernateDAO<Role, Long> implements IRoleDAO {

}
