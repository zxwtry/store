package code02_UserDefinedTypeHandler.main;

import java.util.List;
import java.util.logging.Level;

import org.apache.ibatis.session.SqlSession;

import code02_UserDefinedTypeHandler.mapper.RoleMapper;
import code02_UserDefinedTypeHandler.po.Employee;
import code02_UserDefinedTypeHandler.po.FilePO;
import code02_UserDefinedTypeHandler.po.Role;
import code02_UserDefinedTypeHandler.po.Sex;
import code02_UserDefinedTypeHandler.po.Student;
import code02_UserDefinedTypeHandler.util.SingletonUtil;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SingletonUtil.getSqlSessionFactory().openSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            //插入Role
//          Role role = new Role();
//          role.setNote("note string");
//          role.setRoleName("role name string");
//          roleMapper.insertRole(role);
//          sqlSession.commit();
//          System.out.println(role.getId());
            //输出全部Role
//            System.out.println(roleMapper.findAllRoles());
            //找到某个Role
//            System.out.println(roleMapper.findById(9));
            //删除某个Role
//            System.out.println(roleMapper.deleteRole(9));
//            sqlSession.commit();
            //更新某个Role
//            Role role = roleMapper.findById(8);
//            role.setNote("note new");
//            role.setRoleName("role name new");
//            roleMapper.updateRole(role);
//            sqlSession.commit();
            
            //插入FilePO
//            FilePO filePO = new FilePO();
//            filePO.setName("file po name 5");
//            filePO.setCreateTime(SingletonUtil.getSDF_TIMESTAMP().parse("2017-05-05 08:08:08"));
//            roleMapper.insertFilePO(filePO);
//            sqlSession.commit();
//            System.out.println(filePO.getId());
            //输出全部FilePO
//            List<FilePO> list = roleMapper.findAllFilePOs();
//            System.out.println(list);
            //找到某个FilePO
//            FilePO filePO = roleMapper.findFilePO(5);
//            System.out.println(filePO);
            //删除某个FilePO
//            System.out.println(roleMapper.deleteFilePO(5));
//            sqlSession.commit();
            //更新某个FilePO
//            FilePO filePO = roleMapper.findFilePO(6);
//            filePO.setName("file po name 6 new name");
//            filePO.setCreateTime(SingletonUtil.getSDF_TIMESTAMP().parse("2010-08-14 00:00:00"));
//            roleMapper.updateFilePO(filePO);
//            sqlSession.commit();
            
            //插入Student
//            Student student = new Student();
//            student.setName("student name 6");
//            student.setSex(Sex.MALE);
//            roleMapper.insertStudent(student);
//            sqlSession.commit();
            //输出全部Student
//            List<Student> students = roleMapper.findAllStudents();
//            System.out.println(students);
            //找到某个Student
//            Student student = roleMapper.findStudent(4);
//            System.out.println(student);
            //删除某个Student
//            System.out.println(roleMapper.deleteStudent(4));
//            sqlSession.commit();
            //更新某个Student
//            Student student = roleMapper.findStudent(5);
//            student.setName("student name 5 new name");
//            student.setSex(Sex.MALE);
//            roleMapper.updateStudent(student);
//            sqlSession.commit();
            
            //插入Employee
//            Employee employee = new Employee();
//            employee.setName("employee id 6");
//            employee.setSex(Sex.FEMALE);
//            roleMapper.insertEmployee(employee);
//            sqlSession.commit();
            //输出全部Employee
//            List<Employee> employees = roleMapper.findAllEmployees();
//            System.out.println(employees);
            //找到某个Employee
//            Employee employee = roleMapper.findEmployee(3);
//            System.out.println(employee);
            //删除某个Employee
//            System.out.println(roleMapper.deleteEmployee(3));
//            sqlSession.commit();
            //更新某个Employee
//            Employee employee = roleMapper.findEmployee(5);
//            employee.setName("employee id 5 new name");
//            employee.setSex(Sex.MALE);
//            roleMapper.updateEmployee(employee);
//            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) sqlSession.rollback();
            SingletonUtil.getLogger().log(Level.SEVERE, null, e);
        } finally {
            try {
                if (null != sqlSession) sqlSession.close();
            } catch (Exception e2) {
                SingletonUtil.getLogger().log(Level.SEVERE, null, e2);
            }
        }
    }
}
