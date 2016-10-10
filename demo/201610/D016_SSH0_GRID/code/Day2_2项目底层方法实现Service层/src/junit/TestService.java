package junit;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.zxw.grid.container.ServiceProvider;
import edu.zxw.grid.dao.service.IGridTextService;
import edu.zxw.grid.domain.GridText;
import edu.zxw.grid.web.form.GridTextForm;

public class TestService {
	@Test
	public void saveGridText() {
		for (int i = 0; i < 10; i ++) {
			ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
			IGridTextService gridTextService = (IGridTextService)ac.getBean(IGridTextService.SERVICE_NAME);
			//实例化PO对象，赋值，执行保存
			GridText gridText = new GridText();
			gridText.setTextName("测试Service名称" + i);
			gridText.setTextDate(new Date());
			gridText.setTextRemark("测试Service备注" + (9 - i));
			gridTextService.saveGridText(gridText);
		}
	}
	
	/*
	 * 	通过查询条件，查询对象的列表集合
	 * 	模仿Action层
	 */
	@Test
	public void findCollection() {
		IGridTextService gridTextService = (IGridTextService) ServiceProvider.getService(IGridTextService.SERVICE_NAME);
		GridTextForm gridTextForm = new GridTextForm();
		gridTextForm.setTextName("Service");
		gridTextForm.setTextRemark("Service");
		List<GridText> list = gridTextService.findCollectionByConditionNoPage(gridTextForm);
		System.out.println(list.size());
		for (GridText gridText : list) {
			System.out.println(gridText);
		}
	}
}
