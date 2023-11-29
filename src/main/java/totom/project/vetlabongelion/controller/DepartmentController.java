package totom.project.vetlabongelion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import totom.project.vetlabongelion.model.Department;
import totom.project.vetlabongelion.service.DepartmentService;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String showDepartments(@RequestParam(value="searchQuery", required = false) String searchQuery, Model model) {
        List<Department> departments;
        if (searchQuery == null){
            departments = departmentService.findAll();
        }
        else {
            departments = departmentService.findAll(searchQuery);
        }
        model.addAttribute("departments", departments);
        return "departments";
    }
    @PostMapping
    public String saveDepartment(@ModelAttribute("department")Department department){
        departmentService.save(department);
        return "redirect:/departments";
    }
    @GetMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable("id") Long id){
        System.out.println("Controller: Delete " + id);
        departmentService.deleteById(id);
        return "redirect:/departments";
    }
    @GetMapping("editDepartment/{id}")
    public String handleEditing(@PathVariable String id){
        System.out.println("Get Edit " + id);
        return "redirect:/departments";
    }
    @PostMapping("editDepartment/{id}")
    public String editDepartment(@ModelAttribute("department") Department department){
        departmentService.update(department);
        System.out.println("Post Edit " + department.getId());
        return "redirect:/departments";
    }



}