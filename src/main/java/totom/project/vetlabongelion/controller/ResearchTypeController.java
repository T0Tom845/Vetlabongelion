package totom.project.vetlabongelion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import totom.project.vetlabongelion.model.Department;
import totom.project.vetlabongelion.model.Employee;
import totom.project.vetlabongelion.model.ResearchType;
import totom.project.vetlabongelion.service.DepartmentService;
import totom.project.vetlabongelion.service.EmployeeService;
import totom.project.vetlabongelion.service.ResearchTypeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/research-types")
public class ResearchTypeController {

    private final ResearchTypeService researchTypeService;
    private final DepartmentService departmentService;

    public ResearchTypeController(ResearchTypeService researchTypeService, DepartmentService departmentService) {
        this.researchTypeService = researchTypeService;
        this.departmentService = departmentService;
    }

    @GetMapping
    public String showResearchTypes(@RequestParam(value="searchQuery", required = false) String searchQuery, Model model) {
        List<ResearchType> researchTypes;
        List<Department> departments;
        if (searchQuery == null){
            researchTypes = researchTypeService.findAll();
        }
        else {
            researchTypes = researchTypeService.findAll(searchQuery);
        }
        departments = departmentService.findAll();
        Map<String, List<?>> attributesMap = new HashMap<>();
        attributesMap.put("researchTypes", researchTypes);
        attributesMap.put("departments", departments);
        model.addAllAttributes(attributesMap);
        return "research-types";
    }
    @PostMapping
    public String saveResearchType(@ModelAttribute("researchType")ResearchType researchType){
        researchTypeService.save(researchType);
        return "redirect:/research-types";
    }
    @GetMapping("/deleteResearchType/{id}")
    public String deleteResearchType(@PathVariable("id") Long id){
        System.out.println("Controller: Delete " + id);
        researchTypeService.deleteById(id);
        return "redirect:/research-types";
    }
    @GetMapping("editResearchType/{id}")
    public String handleEditing(@PathVariable String id){
        System.out.println("Get Edit " + id);
        return "redirect:/research-types";
    }
    @PostMapping("editResearchType/{id}")
    public String editResearchType(@ModelAttribute("researchType") ResearchType researchType){
        researchTypeService.update(researchType);
        System.out.println("Post Edit " + researchType.getId());
        return "redirect:/research-types";
    }



}