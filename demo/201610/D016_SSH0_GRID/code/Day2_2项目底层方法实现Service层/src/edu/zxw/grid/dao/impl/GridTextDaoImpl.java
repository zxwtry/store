package edu.zxw.grid.dao.impl;

import org.springframework.stereotype.Repository;

import edu.zxw.grid.dao.IGridTextDao;
import edu.zxw.grid.domain.GridText;

@Repository(IGridTextDao.SERVICE_NAME)
public class GridTextDaoImpl extends CommonDaoImpl<GridText> implements IGridTextDao{
	
}
