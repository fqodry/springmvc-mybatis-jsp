package id.mbingweb.mvc.mybatis.jsp.controller;

import id.mbingweb.mvc.mybatis.jsp.model.Employee;
import id.mbingweb.mvc.mybatis.jsp.model.EmployeeLogin;
import id.mbingweb.mvc.mybatis.jsp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "signup";
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("employee") Employee employee, Model model) {
        if(employeeService.getEmployeeByUsername(employee.getUsername())) {
            model.addAttribute("message", "Username is exists. Try another username.");
            return "signup";
        } else {
            employeeService.insertEmployee(employee);
            model.addAttribute("message", "Saved student details");
            return "redirect:/login.html";
        }
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        EmployeeLogin employeeLogin = new EmployeeLogin();
        model.addAttribute("employeeLogin", employeeLogin);
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("employeeLogin") EmployeeLogin employeeLogin) {
        boolean found = employeeService.getEmployeeByLogin(employeeLogin.getUsername(), employeeLogin.getPassword());
        if(found) {
            return "success";
        } else {
            return "failure";
        }
    }
}
