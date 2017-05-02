package code02_UserDefinedTypeHandler.mapper;

import java.util.List;

import code02_UserDefinedTypeHandler.po.Employee;
import code02_UserDefinedTypeHandler.po.FilePO;
import code02_UserDefinedTypeHandler.po.Role;
import code02_UserDefinedTypeHandler.po.Student;

public interface RoleMapper {
    public int insertRole(Role role);
    public Role findById(int id);
    public List<Role> findAllRoles();
    public int deleteRole(int id);
    public int updateRole(Role role);
    public int insertFilePO(FilePO filePO);
    public FilePO findFilePO(int id);
    public List<FilePO> findAllFilePOs();
    public int deleteFilePO(int id);
    public int updateFilePO(FilePO filePO);
    public int insertStudent(Student student);
    public Student findStudent(int id);
    public List<Student> findAllStudents();
    public int deleteStudent(int id);
    public int updateStudent(Student student);
    public int insertEmployee(Employee employee);
    public Employee findEmployee(int id);
    public List<Employee> findAllEmployees();
    public int deleteEmployee(int id);
    public int updateEmployee(Employee employee);
}
