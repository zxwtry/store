package junit;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.zxw.grid.dao.service.IGridTextService;
import edu.zxw.grid.domain.GridText;

public class TestService {
	@Test
	public void saveGridText() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IGridTextService gridTextService = (IGridTextService)ac.getBean(IGridTextService.SERVICE_NAME);
		//实例化PO对象，赋值，执行保存
		GridText gridText = new GridText();
		gridText.setTextName("测试Service名称");
		gridText.setTextDate(new Date());
		gridText.setTextRemark("测试Service备注");
		gridTextService.saveGridText(gridText);
	}
}
