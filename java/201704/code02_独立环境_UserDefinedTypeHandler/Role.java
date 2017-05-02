package code02_UserDefinedTypeHandler.po;

import code02_UserDefinedTypeHandler.util.SingletonUtil;

/**
    String <--> VARCHAR
    
    create database test_mybatis default charset=utf8;
    create table t_role (
        id int(11) auto_increment primary key,
        role_name varchar(1024),
        note varchar(1024)
    ) engine=InnoDB default charset=utf8;
 */

public class Role {
    private int id;
    private String roleName;
    private String note;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    @Override
    public String toString() {
        return SingletonUtil.getGson().toJson(this);
    }
}
