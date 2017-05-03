package code03_UserDefinedObjectFactory.po;

import code03_UserDefinedObjectFactory.util.SingletonUtil;

/**
    create database test_mybatis default charset=utf8
    create table t_food (
        id int(11) primary key auto_increment,
        food_price float,
        food_name varchar(1024)
    ) engine=InnoDB default charset=utf8;
 */

public class Food {
    private int id;
    private float price;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return SingletonUtil.getGson().toJson(this);
    }
}
