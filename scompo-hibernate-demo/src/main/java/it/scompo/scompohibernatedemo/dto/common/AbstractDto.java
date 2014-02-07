package it.scompo.scompohibernatedemo.dto.common;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import it.scompo.scompohibernatedemo.dao.common.IOperations;

@Transactional
public abstract class AbstractDto<T extends Serializable> implements IOperations<T> {

	@Override
	public T findOne(Serializable id){
		return getDao().findOne(id);
	}

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	public void create(T entity) {
		getDao().create(entity);
	}

	@Override
	public T update(T entity) {
		return getDao().update(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		getDao().deleteById(id);
	}

	protected abstract IOperations<T> getDao();
}
