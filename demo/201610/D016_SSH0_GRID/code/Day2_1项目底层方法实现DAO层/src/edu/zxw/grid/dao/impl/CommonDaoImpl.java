package edu.zxw.grid.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.zxw.grid.dao.ICommonDao;
import edu.zxw.grid.util.GetGenericSuperclass;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {

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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T findObjectByID(Serializable id) {
		//获取当前泛型
		//这样的非业务代码不应该出现在这里，一般都会将这些代码做成Utils
//		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
//		Class entity = (Class) pt.getActualTypeArguments()[0];
		
		Class entity = (Class) GetGenericSuperclass.getClassesByThis(this.getClass())[0];
		
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

}
