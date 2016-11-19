package edu.zxw.goods.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxw.goods.mapper.ItemsMapper;
import edu.zxw.goods.mapper.ItemsMapperCustom;
import edu.zxw.goods.pojo.Items;
import edu.zxw.goods.pojo.ItemsCustom;
import edu.zxw.goods.pojo.ItemsQueryVo;
import edu.zxw.goods.service.ItemsService;

public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	/**
	 * @method		findItemsList 
	 * @parameter	ItemsQueryVo itemsQueryVo	---	传入Items的查询值对象
	 * @return 		List<ItemsCustom>		---	返回Items的子类，ItemsCustom的链表
	 * @details 	抛异常
	 * @details 	商品查询列表
	 */
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	/**
	 * @method		findItemsById 
	 * @parameter	Integer id		---	就是Items的id
	 * @return 		ItemsCustom		---	查询到的Items对象
	 * @details 	抛异常
	 * @details 	根据id查询商品信息
	 */
	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	/**
	 * @method		updateItems 
	 * @parameter	Integer id			---	Items的id
	 * @parameter	ItemsCustom itemsCustom		---	Items的子类ItemsCustom对象
	 * @return 		void
	 * @details 	抛异常
	 * @details 	修改商品信息
	 */
	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		itemsCustom.setId(id);		//updateByPrimaryKeyWithBLOBs必须要对对象设置id
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}

}
