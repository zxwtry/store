package edu.zxw.grid.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public interface ICommonDao<T> {
	void save(T entity);
	void update(T entity);
	T findObjectByID(Serializable id);
	void deleteObjectByIDs(Serializable[] ids);
	void deleteObjectByObjectCollection(Collection<T> list);
	List<T> findCollectionByConditionNoPage(String hqlWhere, Object[] params,
			LinkedHashMap<String, String> orderBy);
}
