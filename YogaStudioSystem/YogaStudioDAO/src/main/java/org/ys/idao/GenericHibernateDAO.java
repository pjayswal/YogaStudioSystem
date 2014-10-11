package org.ys.idao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
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

	public void create(T entity) {
		Transaction rx = sessionFactory.openSession().beginTransaction();
		sessionFactory.getCurrentSession().save(entity);  
		//sessionFactory.getCurrentSession().flush();
		rx.commit();
		
	}
	
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);  
		
	}
	
	@SuppressWarnings("unchecked")
	public T merge(T entity) {
		T t=(T)sessionFactory.getCurrentSession().merge(entity); 
		return t;
		
	}
	

	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);  
		
	}

	@SuppressWarnings("unchecked")
	public void deleteById(ID id) {
		T entity =(T)sessionFactory.getCurrentSession().load(getPersistentClass(), id);
		delete(entity);
		
	}
	 @SuppressWarnings("unchecked")  
	    protected List<T> findByCriteria(Criterion... criterion) {  
	        Criteria crit = sessionFactory.getCurrentSession().createCriteria(getPersistentClass());  
	        for (Criterion c : criterion) {  
	            crit.add(c);  
	        }  
	        return crit.list();  
	   }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}  
	 

}
