package edu.zxw.goods.service;

import java.util.List;

import edu.zxw.goods.pojo.ItemsCustom;
import edu.zxw.goods.pojo.ItemsQueryVo;

/**
 * @author		zxwtry
 * @email		zxwtry@qq.com
 * @project		springmvc1015
 * @package		edu.zxw.goods.service
 * @file		ItemsService.java
 * @date		2016年11月19日 上午10:10:59
 * @details		
 */
public interface ItemsService {

	/**
	 * @method		findItemsList 
	 * @parameter	ItemsQueryVo itemsQueryVo
	 * @return 		List<ItemsCustom>
	 * @details 	抛异常
	 * @details 	商品查询列表
	 */
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	/**
	 * @method		findItemsById 
	 * @parameter	Integer id		---	就是Items id
	 * @return 		ItemsCustom
	 * @details 	抛异常
	 * @details 	根据id查询商品信息
	 */
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	/**
	 * @method		updateItems 
	 * @parameter	Integer id		---	就是Items id
	 * @parameter	ItemsCustom itemsCustom		---	ItemsCustom继承Items，传入itemsCustom用于更新Items
	 * @return 		void
	 * @details 	抛异常
	 * @details 	修改商品信息
	 */
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;
}
