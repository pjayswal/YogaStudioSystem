package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.ys.commons.Waiver;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IWaiverDAO;
@Repository
public class WaiverDAO extends GenericHibernateDAO<Waiver, Long> implements IWaiverDAO {

}
