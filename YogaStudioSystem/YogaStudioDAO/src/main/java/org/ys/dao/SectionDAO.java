package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.ys.commons.Section;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.ISectionDAO;
@Repository
public class SectionDAO extends GenericHibernateDAO<Section, Long> implements ISectionDAO{

}
