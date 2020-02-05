package id.mbingweb.mvc.mybatis.jsp.service;

import id.mbingweb.mvc.mybatis.jsp.model.Employee;

public interface EmployeeService {
    void insertEmployee(Employee employee);
    boolean getEmployeeByLogin(String username, String password);
    boolean getEmployeeByUsername(String username);
}
