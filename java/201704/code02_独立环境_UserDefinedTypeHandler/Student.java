package code02_UserDefinedTypeHandler.po;

import code02_UserDefinedTypeHandler.util.SingletonUtil;

/**
    String <--> VARCHAR
    Enum <--> INTEGER
    
    org.apache.ibatis.type.EnumOrdinalTypeHandler
    
    create database test_mybatis default charset=utf8;
    create table t_student (
        id int(11) auto_increment primary key,
        student_name varchar(1024),
        student_sex int
    ) engine=InnoDB default charset=utf8;
*/

public class Student {
    private int id;
    private String name;
    private Sex sex;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    @Override
    public String toString() {
        return SingletonUtil.getGson().toJson(this);
    }
}
