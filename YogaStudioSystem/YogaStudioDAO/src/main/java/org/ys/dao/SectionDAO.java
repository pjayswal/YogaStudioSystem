package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Section;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.ISectionDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class SectionDAO extends GenericHibernateDAO<Section, Long> implements ISectionDAO{

}
