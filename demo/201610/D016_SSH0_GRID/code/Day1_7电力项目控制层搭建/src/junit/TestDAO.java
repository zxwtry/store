package junit;

import java.util.Date;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.zxw.grid.dao.IGridTextDao;
import edu.zxw.grid.domain.GridText;

public class TestDAO {
	@Test
	public void saveGridText() {
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 100; i ++) {
			ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
			IGridTextDao gridTextDao = (IGridTextDao)ac.getBean(IGridTextDao.SERVICE_NAME);
			//实例化PO对象，赋值，执行保存
			GridText gridText = new GridText();
			gridText.setTextName("测试DAO名称");
			gridText.setTextDate(new Date());
			gridText.setTextRemark("测试DAO备注");
			gridTextDao.save(gridText);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("新建ac的时间是：" + (t2 - t1));
		/*
		 * 	time is 14764
		 */
	}
}