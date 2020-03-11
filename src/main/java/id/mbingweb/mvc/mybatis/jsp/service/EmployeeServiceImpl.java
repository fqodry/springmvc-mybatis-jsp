package id.mbingweb.mvc.mybatis.jsp.service;

import id.mbingweb.mvc.mybatis.jsp.mapper.EmployeeMapper;
import id.mbingweb.mvc.mybatis.jsp.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    
    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }
    
    @Override
    @Transactional
    public void insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }
    
    @Override
    public boolean getEmployeeByLogin(String username, String password) {
        Employee employee = employeeMapper.getEmployeeByUsername(username);
        
        return employee != null && employee.getPassword().equals(password);
    }
    
    @Override
    public boolean getEmployeeByUsername(String username) {
        Employee employee = employeeMapper.getEmployeeByUsername(username);
        
        return employee != null;
    }
}
