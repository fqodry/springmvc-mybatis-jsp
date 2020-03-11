package id.mbingweb.mvc.mybatis.jsp.service;

import id.mbingweb.mvc.mybatis.jsp.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void insertEmployee(Employee employee);
    boolean getEmployeeByLogin(String username, String password);
    boolean getEmployeeByUsername(String username);
}
