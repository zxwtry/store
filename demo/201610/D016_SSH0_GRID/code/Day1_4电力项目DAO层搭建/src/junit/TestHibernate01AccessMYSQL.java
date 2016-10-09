package junit;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import edu.zxw.grid.domain.GridText;

public class TestHibernate01AccessMYSQL {
	@Test
	public void testGridText() {
		Configuration configuration = new Configuration();
		configuration.configure();	//默认加载src下面hibernate.cfg.xml
		//创建sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//打开session操作数据库
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//实例化GridText对象，添加数据。执行保存操作
		GridText gridText = new GridText();
		gridText.setTextName("测试Hibernate名称");
		gridText.setTextDate(new Date());
		gridText.setTextRemark("测试Hibernate备注");
		//保存
		session.save(gridText);
		transaction.commit();
		session.close();
	}
}
