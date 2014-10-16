package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Order;
import org.ys.commons.Payment;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.IOrderDAO;
import org.ys.idao.IPaymentDAO;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class PaymentDAO extends GenericHibernateDAO<Payment, Long> implements IPaymentDAO{

}
