package edu.zxw.goods.pojo;


import java.util.Date;

/**
 * @author		zxwtry
 * @email		zxwtry@qq.com
 * @project		springmvc1015
 * @package		edu.zxw.goods.pojo
 * @file		User.java
 * @date		2016年11月19日 上午11:21:38
 * @details		用户表
 * @details		id		---	用户表主键
 * @details		username	---	用户名称
 * @details		birthday	---	生日
 * @details		sex			---	性别
 * @details		address		---	地址
 */
public class User {
    private Integer id;

    private String username;

    private Date birthday;

    private String sex;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}