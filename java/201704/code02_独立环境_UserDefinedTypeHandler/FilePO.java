package code02_UserDefinedTypeHandler.po;

import java.util.Date;

import code02_UserDefinedTypeHandler.util.SingletonUtil;

/**
    String <--> VARCHAR
    Date <--> BIGINT
    
    create database test_mybatis default charset=utf8;
    create table t_file_po (
        id int(11) auto_increment primary key,
        file_name varchar(1024),
        create_time bigint
    ) engine=InnoDB default charset=utf8;
 */

public class FilePO {
    private int id;
    private String name;
    private Date createTime;
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
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Override
    public String toString() {
        return SingletonUtil.getGson().toJson(this);
    }
}
