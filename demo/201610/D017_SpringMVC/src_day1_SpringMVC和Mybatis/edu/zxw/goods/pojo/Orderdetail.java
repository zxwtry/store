package edu.zxw.goods.pojo;


/**
 * @author		zxwtry
 * @email		zxwtry@qq.com
 * @project		springmvc1015
 * @package		edu.zxw.goods.pojo
 * @file		Orderdetail.java
 * @date		2016年11月19日 上午11:17:25
 * @details		订单明细表 
 * @details		id 		---	订单明细表主键
 * @details		ordersId 		---	订单外键
 * @details		itemsId 		---	商品外键
 * @details		itemsNum 		---	商品数量
 */
public class Orderdetail {
    private Integer id;

    private Integer ordersId;

    private Integer itemsId;

    private Integer itemsNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(Integer itemsNum) {
        this.itemsNum = itemsNum;
    }
}