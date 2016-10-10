package junit;

import java.util.Date;

import org.junit.Test;

import edu.zxw.grid.container.ServiceProvider;
import edu.zxw.grid.dao.service.IGridTextService;
import edu.zxw.grid.domain.GridText;

public class TestWeb {
	
	@Test
	public void save () {
		long t1 = System.currentTimeMillis();
		IGridTextService gridTextService = (IGridTextService)ServiceProvider.getService(IGridTextService.SERVICE_NAME);
		for (int i = 0; i < 100; i ++) {
	//		IGridTextService gridTextService = (IGridTextService)sp.getService("aabb");
			GridText gridText = new GridText();
			gridText.setTextName("测试Web名称");
			gridText.setTextDate(new Date());
			gridText.setTextRemark("测试Web备注");
			gridTextService.saveGridText(gridText);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("重用ac的时间是：" + (t2 - t1));
		/*
		 * 	time is 4468
		 * 	time is 3955
		 */
	}
}
