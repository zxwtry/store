package edu.zxw.goods.mapper;

import java.util.List;

import edu.zxw.goods.pojo.ItemsCustom;
import edu.zxw.goods.pojo.ItemsQueryVo;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}