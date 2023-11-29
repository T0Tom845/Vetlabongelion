package totom.project.vetlabongelion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import totom.project.vetlabongelion.model.Employee;
import totom.project.vetlabongelion.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String showEmployees(@RequestParam(value="searchQuery", required = false) String searchQuery, Model model) {
        List<Employee> employees;
        if (searchQuery == null){
            employees = employeeService.findAll();
        }
        else {
            employees = employeeService.findAll(searchQuery);
        }
        model.addAttribute("employees", employees);
        return "employees";
    }
    @PostMapping
    public String saveEmployee(@ModelAttribute("employee")Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        System.out.println("Controller: Delete " + id);
        employeeService.deleteById(id);
        return "redirect:/employees";
    }
    @GetMapping("editEmployee/{id}")
    public String handleEditing(@PathVariable String id){
        System.out.println("Get Edit " + id);
        return "redirect:/employees";
    }
    @PostMapping("editEmployee/{id}")
    public String editEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.update(employee);
        System.out.println("Post Edit " + employee.getId());
        return "redirect:/employees";
    }



}