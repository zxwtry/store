package code01_ConfiguringMybatis.main;

import org.apache.ibatis.session.SqlSession;

import code01_ConfiguringMybatis.mapper.RoleMapper;
import code01_ConfiguringMybatis.po.Role;
import code01_ConfiguringMybatis.util.SqlSessionFactoryUtil;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("testName");
            role.setNote("testNote");
            roleMapper.insertRole(role);
            roleMapper.deleteRole(4);
            sqlSession.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }
    }
}
