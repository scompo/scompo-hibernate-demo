package it.scompo.scompohibernatedemo.dao.common;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {

	private Class<T> classs;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//Api
	protected final void setClasss(final Class<T> classsToSet) {
		if(classsToSet!=null)
		classs = classsToSet;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public final T findOne(final Serializable id) {
		return (T) getCurrentSession().get(classs, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getCurrentSession().createQuery("from "+ classs.getName()).list();
	}

	@Override
	public void create(final T entity) {
		if(entity !=null){
			getCurrentSession().saveOrUpdate(entity);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T update(final T entity) {
		if(entity !=null){
			return (T) getCurrentSession().merge(entity);
		}else{
			return entity;
		}
	}

	@Override
	public void delete(final T entity) {
		if(entity !=null){
			getCurrentSession().delete(entity);
		}
	}

	@Override
	public void deleteById(final Serializable id) {
		T entity = findOne(id);
		if(entity !=null){
			delete(entity);
		}
	}
	
	protected final Session getCurrentSession() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession();
	}
}
