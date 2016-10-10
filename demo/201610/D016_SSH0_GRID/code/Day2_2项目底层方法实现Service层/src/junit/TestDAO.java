package junit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.zxw.grid.container.ServiceProvider;
import edu.zxw.grid.dao.IGridTextDao;
import edu.zxw.grid.domain.GridText;

public class TestDAO {
	@Test
	public void saveGridText() {
		long t1 = System.currentTimeMillis();
//		for (int i = 0; i < 100; i ++) {
			ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
			IGridTextDao gridTextDao = (IGridTextDao)ac.getBean(IGridTextDao.SERVICE_NAME);
			//实例化PO对象，赋值，执行保存
			GridText gridText = new GridText();
			gridText.setTextName("测试DAO名称1338");
			gridText.setTextDate(new Date());
			gridText.setTextRemark("测试DAO备注1338");
			gridTextDao.save(gridText);
//		}
		long t2 = System.currentTimeMillis();
		System.out.println("新建ac的时间是：" + (t2 - t1));
		/*
		 * 	time is 14764
		 */
	}
	
	@Test
	public void update() {
		IGridTextDao gridTextDao = (IGridTextDao) ServiceProvider.getService(IGridTextDao.SERVICE_NAME);
//		IGridTextService gridTextService = (IGridTextService) ServiceProvider.getService(IGridTextService.SERVICE_NAME);
		GridText gridText = new GridText();
		gridText.setTextName("update的新名字2333");
		gridText.setTextID("402881d957ad70400157ad7043d60001");
		gridText.setTextDate(new Date());
		gridText.setTextRemark("update的新备注2333");
		gridTextDao.update(gridText);
	}
	
	//通过ID查询Object
	@Test
	public void findObjectByID() {
//		IGridTextService gridTextService = (IGridTextService) ServiceProvider.getService(IGridTextService.SERVICE_NAME);
		IGridTextDao gridTextDao = (IGridTextDao) ServiceProvider.getService(IGridTextDao.SERVICE_NAME);
		Serializable id = "402881d957ad70400157ad7043d60001";
		GridText gridText =  gridTextDao.findObjectByID(id);
		System.out.println(gridText.getTextName());
		System.out.println(gridText.getTextRemark());
	}
	
	//通过ID删除Object
	@Test
	public void deleteObjectByIDs() {
		IGridTextDao gridTextDao = (IGridTextDao) ServiceProvider.getService(IGridTextDao.SERVICE_NAME);
//		IGridTextService gridTextService = (IGridTextService) ServiceProvider.getService(IGridTextService.SERVICE_NAME);
		Serializable[] ids = new Serializable[] {
			"402881d957ad70400157ad7043d60001",
//			"402881d957ad12460157ad124a8d0001"
		};
		gridTextDao.deleteObjectByIDs(ids);
	}
	
	//通过ID删除Object
	@Test
	public void deleteObjectByObjectCollection() {
		IGridTextDao gridTextDao = (IGridTextDao) ServiceProvider.getService(IGridTextDao.SERVICE_NAME);
//		IGridTextService gridTextService = (IGridTextService) ServiceProvider.getService(IGridTextService.SERVICE_NAME);
		List<GridText> list = new ArrayList<>();
//		GridText gridText1 = findAnObjectByID("402881d957ad16e70157ad16ed250002");
		GridText gridText1 = new GridText();
		gridText1.setTextID("402881d957ad3a640157ad3a68c00001");
		list.add(gridText1);
		GridText gridText2 = new GridText();
		gridText2.setTextID("402881d957ad3a9f0157ad3aa4040001");
		list.add(gridText2);
		GridText gridText3 = new GridText();
		gridText3.setTextID("402881d957ad3ab00157ad3ab4a80001");
		list.add(gridText3);
		gridTextDao.deleteObjectByObjectCollection(list);
	}
	
	public GridText findAnObjectByID(Serializable id) {
		IGridTextDao gridTextDao = (IGridTextDao) ServiceProvider.getService(IGridTextDao.SERVICE_NAME);
//		IGridTextService gridTextService = (IGridTextService) ServiceProvider.getService(IGridTextService.SERVICE_NAME);
		GridText gridText =  gridTextDao.findObjectByID(id);
		return gridText;
	}
}