package org.ys.idao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericHibernateDAO<T,ID extends Serializable> implements IGenericDAO<T,ID> {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> persistentClass;
	
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T get(ID id) {
		return (T)sessionFactory.getCurrentSession().get(getPersistentClass(), id);
	}

	public List<T> getAll() {
		return findByCriteria();  
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
		T entity;  
        if (lock)  
            entity = (T) sessionFactory.getCurrentSession().load(getPersistentClass(), id, LockOptions.UPGRADE);  
        else  
            entity = (T) sessionFactory.getCurrentSession().load(getPersistentClass(), id);  
  
        return entity;  
	}

	public T makePersistent(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);  
        return entity;  
		
	}

	public void makeTransient(T entity) {
		sessionFactory.getCurrentSession().delete(entity);  
		
	}

	@SuppressWarnings("unchecked")
	public void deleteById(ID id) {
		T entity =(T)sessionFactory.getCurrentSession().load(getPersistentClass(), id);
		makeTransient(entity);
		
	}
	 @SuppressWarnings("unchecked")  
	    protected List<T> findByCriteria(Criterion... criterion) {  
	        Criteria crit = sessionFactory.getCurrentSession().createCriteria(getPersistentClass());  
	        for (Criterion c : criterion) {  
	            crit.add(c);  
	        }  
	        return crit.list();  
	   }  

}
