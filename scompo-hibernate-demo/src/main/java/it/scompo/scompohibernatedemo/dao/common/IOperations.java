package it.scompo.scompohibernatedemo.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 * Operations interface.
 * 
 * @author mscomparin
 * @version 1.0
 */
public interface IOperations<T extends Serializable>{
	
	T findOne(final Serializable id);
	
	List<T> findAll();
	
	void create(final T entity);
	
	T update(final T entity);
	
	void delete(final T entity);
	
	void deleteById(final Serializable id);
}
