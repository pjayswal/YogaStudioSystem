package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.UserCredential;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IUserCredentialDAO;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class UserCredentialDAO extends GenericHibernateDAO<UserCredential, String> implements IUserCredentialDAO {

}
