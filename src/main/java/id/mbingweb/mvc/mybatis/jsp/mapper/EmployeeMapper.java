package id.mbingweb.mvc.mybatis.jsp.mapper;

import id.mbingweb.mvc.mybatis.jsp.model.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper {
    @Insert("INSERT INTO employee(username, password, firstname, lastname,"
        + "date_of_birth, email) VALUES(#{username}, #{password}, #{firstname},"
        + "#{lastname}, #{dateOfBirth}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void insertEmployee(Employee employee);
    
    @Select("SELECT username, password, firstname, lastname,"
        + "date_of_birth AS dateOfBirth, email "
        + "FROM employee WHERE username = #{username}")
    public Employee getEmployeeByUsername(String username);
}
