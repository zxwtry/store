package edu.zxw.goods.pojo;


import java.util.Date;

/**
 * @author		zxwtry
 * @email		zxwtry@qq.com
 * @project		springmvc1015
 * @package		edu.zxw.goods.pojo
 * @file		Orders.java
 * @date		2016年11月19日 上午11:18:58
 * @details		订单表
 * @details		id			---	订单表主键
 * @details		userId		---	用户外键
 * @details		number		---	订单号
 * @details		createtime		---	订单表创建时间
 * @details		note		---	订单表的状态
 */
public class Orders {
    private Integer id;

    private Integer userId;

    private String number;

    private Date createtime;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}