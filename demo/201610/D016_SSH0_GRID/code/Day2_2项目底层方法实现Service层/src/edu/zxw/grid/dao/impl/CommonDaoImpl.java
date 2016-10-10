package edu.zxw.grid.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.zxw.grid.dao.ICommonDao;
import edu.zxw.grid.util.GetGenericSuperclass;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {
	

	@SuppressWarnings("rawtypes")
	private Class entity = (Class) GetGenericSuperclass.getClassesByThis(this.getClass())[0];

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}
	
	@Resource(name="sessionFactory")
	public final void setSessionFactoryMy(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findObjectByID(Serializable id) {
		//获取当前泛型
		//这样的非业务代码不应该出现在这里，一般都会将这些代码做成Utils
//		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
//		Class entity = (Class) pt.getActualTypeArguments()[0];
		
//		return  (T) this.getHibernateTemplate().get(GridText.class , id);
		return  (T) this.getHibernateTemplate().get(entity, id);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void deleteObjectByIDs(Serializable[] ids) {
		HibernateTemplate ht = this.getHibernateTemplate();
		Class entityClass = (Class) GetGenericSuperclass.getClassesByThis(this.getClass())[0];
		for (Serializable id : ids) {
			Object obj = ht.get(entityClass, id);
			if (obj == null) {
				System.out.println(String.format("ID:%s是没有存储在数据库的Ojbect\r\n", ids.toString()));
			} else {
				ht.delete(obj);
			}
		}
	}

	@Override
	public void deleteObjectByObjectCollection(Collection<T> list) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.deleteAll(list);
//		for (T t : list) {
//			if (ht.contains(t)) {
//			System.out.println(ht.contains(t));
//			ht.delete(t);
//			} else {
//				System.out.println(String.format("Object(%s)是没有存储在数据库\r\n", t.toString()));
//			}
//		}
	}

	//使用查询条件查询列表的集合(不分页)
	//hqlWhere：	hql语句的where条件　
	//params：	where条件的查询参数
	//orderBy：	排序条件
	@Override
	public List<T> findCollectionByConditionNoPage(String hqlWhere, final Object[] params,
			LinkedHashMap<String, String> orderBy) {
		/*
		 * 	select o.text_name, o.text_remark from grid_text o where 1=1  放置到DAO层
		    and o.text_name like '%张%'                       放置到Service层 
		    and o.text_remark like '%李%'                       放置到Service层
	    	order by o.text_date desc, o.tex_name asc;          放置到Service层
		 */
		String hql = String.format(" from %s o where 1=1 ", entity.getSimpleName());
		String hqlOrderBy = " order by ";
		for (Map.Entry<String, String> map : orderBy.entrySet()) {
			map.getKey();
			map.getValue();
			hqlOrderBy += String.format(" %s %s , ", map.getKey(), map.getValue());
		}
		hqlOrderBy = hqlOrderBy.substring(0, hqlOrderBy.length() - 2);
		hql = hql + hqlWhere + hqlOrderBy;
		final String finalHQL = hql;
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>)this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(finalHQL);
						
						for (int i = 0; params != null && i < params.length; i ++) {
							query.setParameter(i, params[i]);
						}
						return query.list();
					}
				}
				);
		return list;
	}

}
