package code01_ConfiguringMybatis.mapper;

import code01_ConfiguringMybatis.po.Role;

public interface RoleMapper {
    public Role getRole(int id);
    public int deleteRole(int id);
    public int insertRole(Role role);
}
