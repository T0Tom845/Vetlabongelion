package totom.project.vetlabongelion.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import totom.project.vetlabongelion.model.Department;
import totom.project.vetlabongelion.model.Employee;
import totom.project.vetlabongelion.service.DepartmentService;
import totom.project.vetlabongelion.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping(params = "!searchQuery")
    public String showEmployees(Model model) {
        List<Employee> employees;
        List<Department> departments;
        employees = employeeService.findAll();
        departments = departmentService.findAll();
        employees.forEach(employee -> employee.setDepartment(departmentService.findById(employee.getDepId())));
        Map<String, List<?>> attributesMap = new HashMap<>();
        attributesMap.put("employees", employees);
        attributesMap.put("departments", departments);
        model.addAllAttributes(attributesMap);
        return "employees";
    }

    @GetMapping(params = "searchQuery")
    public String showEmployeesBySearch(@RequestParam(value = "searchQuery") String searchQuery, Model model) {
        List<Employee> employees;
        employees = employeeService.findAll(searchQuery);
        model.addAttribute("employees", employees);
        return "employees";
    }

    @PostMapping
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        System.out.println("Controller: Delete " + id);
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    @GetMapping("editEmployee/{id}")
    public String handleEditing(@PathVariable String id) {
        System.out.println("Get Edit " + id);
        return "redirect:/employees";
    }

    @PostMapping("editEmployee/{id}")
    public String editEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.update(employee);
        System.out.println("Post Edit " + employee.getId());
        return "redirect:/employees";
    }


}