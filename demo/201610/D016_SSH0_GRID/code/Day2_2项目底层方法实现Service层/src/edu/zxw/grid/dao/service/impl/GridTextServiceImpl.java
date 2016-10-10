package edu.zxw.grid.dao.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.zxw.grid.dao.IGridTextDao;
import edu.zxw.grid.dao.service.IGridTextService;
import edu.zxw.grid.domain.GridText;
import edu.zxw.grid.web.form.GridTextForm;

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
	
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public void update(GridText gridText) {
		gridTextDao.update(gridText);
	}

	@Override
	public GridText findObjectByID(Serializable id) {
		return gridTextDao.findObjectByID(id);
	}

	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public void deleteObjectByIDs(Serializable[] ids) {
		gridTextDao.deleteObjectByIDs(ids);
	} 

	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public void deleteObjectByObjectCollection(List<GridText> list) {
		gridTextDao.deleteObjectByObjectCollection(list);
	}

	//使用查询条件查询列表的集合(不分页)
	/*
	 *	select o.text_name, o.text_remark from grid_text o  放置到DAO层
	    where o.text_name like '%张%'                       放置到Service层 
	    and o.text_remark like '%李%'                       放置到Service层
	    order by o.text_date desc, o.tex_name asc;          放置到Service层
	 */
	/*
	 * 	这里有一个问题
	 * 	对条件的分类的时候，	
	 * 	第一条是where
	 * 	之后却是add
	 * 	这样非常不适合进行分层
	 * 	将sql语句更改为如下：
	 * 	select o.text_name, o.text_remark from grid_text o where 1=1
	 * 	add o.text_name like '%张%' 
	 * 	and o.text_remark like '%李%'
	 * 	order by o.text_date desc, o.tex_name asc;
	 */
	@Override
	public List<GridText> findCollectionByConditionNoPage(GridTextForm gridTextForm) {
		List<String> paramsList = new ArrayList<>();
		String hqlWhere = generateHQLWhereAndParams(gridTextForm, paramsList);
//		if (gridTextForm != null && gridTextForm.getTextName() != null) {
//			hqlWhere += "where o.text_name like ?";
//			paramsList.add("%" + gridTextForm.getTextName() + "%");
//		}
//		if (gridTextForm != null && gridTextForm.getTextRemark() != null) {
//			hqlWhere += " and o.text_remark like ?";
//			paramsList.add("%" + gridTextForm.getTextRemark() + "%");
//		}
		Object[] params = paramsList.toArray();
		//组织排序语句
		LinkedHashMap<String, String> orderBy = new LinkedHashMap<>();
		orderBy.put("o.textDate", "desc");
		orderBy.put("o.textName", "asc");
		//组织查询列表的语句
		List<GridText> list = gridTextDao.findCollectionByConditionNoPage(hqlWhere, params, orderBy);
		return list;
	}

	private String generateHQLWhereAndParams(GridTextForm gridTextForm, List<String> paramsList) {
		StringBuilder st = new StringBuilder();
		if (gridTextForm != null && gridTextForm.getTextName() != null) {
			st.append(" and o.textName like ? ");
			paramsList.add(String.format("%%%s%%", gridTextForm.getTextName()));
		}
		if (gridTextForm != null && gridTextForm.getTextRemark() != null) {
			st.append(" and o.textRemark like ? ");
			paramsList.add(String.format("%%%s%%", gridTextForm.getTextRemark()));
		}
		return st.toString();
	}

}