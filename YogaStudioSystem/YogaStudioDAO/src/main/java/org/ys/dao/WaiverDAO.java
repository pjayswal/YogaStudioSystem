package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Waiver;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IWaiverDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class WaiverDAO extends GenericHibernateDAO<Waiver, Long> implements IWaiverDAO {

}
