package edu.zxw.grid.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.zxw.grid.dao.ICommonDao;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}
	
	@Resource(name="sessionFactory")
	public final void setSessionFactoryMy(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

}
