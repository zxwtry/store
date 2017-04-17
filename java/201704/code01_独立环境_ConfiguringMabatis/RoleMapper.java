package code01_ConfiguringMabatis.mapper;

import code01_ConfiguringMabatis.po.Role;

public interface RoleMapper {
    public Role getRole(int id);
    public int deleteRole(int id);
    public int insertRole(Role role);
}
