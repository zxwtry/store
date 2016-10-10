package edu.zxw.grid.web.action;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ModelDriven;

import edu.zxw.grid.container.ServiceProvider;
import edu.zxw.grid.dao.service.IGridTextService;
import edu.zxw.grid.domain.GridText;
import edu.zxw.grid.util.StringHelper;
import edu.zxw.grid.web.form.GridTextForm;

@SuppressWarnings("serial")
public class GridTextAction extends BaseAction implements ServletRequestAware, ModelDriven<GridTextForm> {
	
	private static GridTextForm gridTextForm = null;
	private static IGridTextService gridTextService = null;
	
	static {
		gridTextForm = new GridTextForm();
		gridTextService = (IGridTextService)ServiceProvider.getService(IGridTextService.SERVICE_NAME);
	}
	
	@Override
	public GridTextForm getModel() {
		return gridTextForm;
	}
	
	public String save() {
		//VO对象转换成PO对象
		//实例化PO对象
		GridText gridText = new GridText();
		gridText.setTextName(gridTextForm.getTextName());
		gridText.setTextDate(StringHelper.stringConvertDate(gridTextForm.getTextDate()));
		gridText.setTextRemark(gridTextForm.getTextRemark());
		gridTextService.saveGridText(gridText);
		return "save";
	}

}