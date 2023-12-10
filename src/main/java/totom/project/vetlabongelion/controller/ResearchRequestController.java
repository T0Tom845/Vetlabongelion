package totom.project.vetlabongelion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import totom.project.vetlabongelion.model.*;
import totom.project.vetlabongelion.service.ClientService;
import totom.project.vetlabongelion.service.EmployeeService;
import totom.project.vetlabongelion.service.ResearchRequestService;
import totom.project.vetlabongelion.service.SampleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/research-requests")
public class ResearchRequestController {

    private final ResearchRequestService researchRequestService;
    private final EmployeeService employeeService;
    private final ClientService clientService;
    private final SampleService sampleService;

    public ResearchRequestController(ResearchRequestService researchRequestService,
                                     EmployeeService employeeService,
                                     ClientService clientService,
                                     SampleService sampleService) {
        this.researchRequestService = researchRequestService;
        this.employeeService = employeeService;
        this.clientService = clientService;
        this.sampleService = sampleService;
    }

    @GetMapping
    public String showResearchRequests(@RequestParam(value="searchQuery", required = false) String searchQuery, Model model) {
        List<ResearchRequest> researchRequests;
        List<Employee> employees;
        List<Client> clients;
        List<Sample> samples;
        if (searchQuery == null){
            researchRequests = researchRequestService.findAll();
        }
        else {
            researchRequests = researchRequestService.findAll(searchQuery);
        }
        Map<String, List<?>> attributesMap = new HashMap<>();
        employees = employeeService.findAll();
        clients = clientService.findAll();
        samples = sampleService.findAll();
        attributesMap.put("researchRequests", researchRequests);
        attributesMap.put("employees", employees);
        attributesMap.put("clients", clients);
        attributesMap.put("samples", samples);
        model.addAllAttributes(attributesMap);
        return "research-requests";
    }
    @PostMapping
    public String saveResearchRequest(@ModelAttribute("researchRequest")ResearchRequest researchRequest){
        researchRequestService.save(researchRequest);
        return "redirect:/research-requests";
    }
    @GetMapping("/deleteResearchRequest/{id}")
    public String deleteResearchRequest(@PathVariable("id") Long id){
        System.out.println("Controller: Delete " + id);
        researchRequestService.deleteById(id);
        return "redirect:/research-requests";
    }
    @GetMapping("editResearchRequest/{id}")
    public String handleEditing(@PathVariable String id){
        System.out.println("Get Edit " + id);
        return "redirect:/research-requests";
    }
    @PostMapping("editResearchRequest/{id}")
    public String editResearch(@ModelAttribute("research") ResearchRequest researchRequest){
        researchRequestService.update(researchRequest);
        System.out.println("Post Edit " + researchRequest.getId());
        return "redirect:/research-requests";
    }



}