package edu.zxw.grid.dao;

import java.io.Serializable;
import java.util.Collection;

public interface ICommonDao<T> {
	void save(T entity);
	void update(T entity);
	T findObjectByID(Serializable id);
	void deleteObjectByIDs(Serializable[] ids);
	void deleteObjectByObjectCollection(Collection<T> list);
}
