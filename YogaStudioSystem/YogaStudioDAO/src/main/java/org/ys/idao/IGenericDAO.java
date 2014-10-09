package org.ys.idao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T, ID extends Serializable> {

	public T get(ID id);

	public T findById(ID id, boolean lock);

	public List<T> getAll();

	public void create(T entity);
	
	public void update(T entity);
	
	public T merge(T entity);

	public void delete(T entity);

	void deleteById(final ID entityId);

}
