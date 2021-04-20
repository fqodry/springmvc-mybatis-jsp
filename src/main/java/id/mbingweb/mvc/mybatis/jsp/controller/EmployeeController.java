package id.mbingweb.mvc.mybatis.jsp.controller;

import id.mbingweb.mvc.mybatis.jsp.model.Employee;
import id.mbingweb.mvc.mybatis.jsp.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("")
    public String list(Model model) {
        List<Employee> listEmployee = employeeService.getAllEmployee();
        model.addAttribute("listEmployee", listEmployee);
        System.out.println("hello=" + listEmployee);
        
        return "/employee/employee-list";
    }
    
    @GetMapping("/add")
    public String add(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        
        return "/employee/employee-add";
    }
}
