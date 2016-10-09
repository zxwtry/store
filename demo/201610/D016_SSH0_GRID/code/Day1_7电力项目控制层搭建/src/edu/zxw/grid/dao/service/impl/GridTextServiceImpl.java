package edu.zxw.grid.dao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.zxw.grid.dao.IGridTextDao;
import edu.zxw.grid.dao.service.IGridTextService;
import edu.zxw.grid.domain.GridText;

@Transactional(readOnly=true)
@Service(IGridTextService.SERVICE_NAME)
public class GridTextServiceImpl implements IGridTextService {

	@Resource(name=IGridTextDao.SERVICE_NAME)
	private IGridTextDao gridTextDao;
		
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED, readOnly=false)
//	@Transactional(readOnly=false)
	@Override
	public void saveGridText(GridText gridText) {
		gridTextDao.save(gridText);
	}

}