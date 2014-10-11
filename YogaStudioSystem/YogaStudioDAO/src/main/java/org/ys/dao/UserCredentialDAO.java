package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.ys.commons.UserCredential;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IUserCredentialDAO;

@Repository

public class UserCredentialDAO extends GenericHibernateDAO<UserCredential, String> implements IUserCredentialDAO {

}
