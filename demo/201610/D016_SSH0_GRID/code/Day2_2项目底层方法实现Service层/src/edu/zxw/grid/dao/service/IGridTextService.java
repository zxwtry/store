package edu.zxw.grid.dao.service;

import java.io.Serializable;
import java.util.List;

import edu.zxw.grid.domain.GridText;
import edu.zxw.grid.web.form.GridTextForm;

public interface IGridTextService {
	public static final String SERVICE_NAME = "edu.zxw.grid.dao.service.impl.GridTextServiceImpl";
	public void saveGridText(GridText gridText);
	public void update(GridText gridText);
	public GridText findObjectByID(Serializable id);
	public void deleteObjectByIDs(Serializable[] ids);
	public void deleteObjectByObjectCollection(List<GridText> list);
	public List<GridText> findCollectionByConditionNoPage(GridTextForm gridTextForm);
}
