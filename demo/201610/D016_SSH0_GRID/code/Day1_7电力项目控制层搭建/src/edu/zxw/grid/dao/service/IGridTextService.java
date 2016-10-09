package edu.zxw.grid.dao.service;

import edu.zxw.grid.domain.GridText;

public interface IGridTextService {
	public static final String SERVICE_NAME = "edu.zxw.grid.dao.service.impl.GridTextServiceImpl";
	public void saveGridText(GridText gridText);
}
