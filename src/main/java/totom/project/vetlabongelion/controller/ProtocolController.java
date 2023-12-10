package totom.project.vetlabongelion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import totom.project.vetlabongelion.model.Client;
import totom.project.vetlabongelion.model.Employee;
import totom.project.vetlabongelion.model.Protocol;
import totom.project.vetlabongelion.service.ClientService;
import totom.project.vetlabongelion.service.EmployeeService;
import totom.project.vetlabongelion.service.ProtocolService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/protocols")
public class ProtocolController {

    private final ProtocolService protocolService;
    private final ClientService clientService;
    private final EmployeeService employeeService;

    public ProtocolController(ProtocolService protocolService, ClientService clientService, EmployeeService employeeService) {
        this.protocolService = protocolService;
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String showProtocols(@RequestParam(value="searchQuery", required = false) String searchQuery, Model model) {
        List<Protocol> protocols;
        List<Client> clients;
        List<Employee> employees;
        if (searchQuery == null){
            protocols = protocolService.findAll();
        }
        else {
            protocols = protocolService.findAll(searchQuery);
        }
        clients = clientService.findAll();
        employees = employeeService.findAll();
        Map<String, List<?>> attributesMap = new HashMap<>();
        attributesMap.put("protocols", protocols);
        attributesMap.put("clients", clients);
        attributesMap.put("employees", employees);
        model.addAllAttributes(attributesMap);
        return "protocols";
    }
    @PostMapping
    public String saveProtocol(@ModelAttribute("protocol")Protocol protocol){
        protocolService.save(protocol);
        return "redirect:/protocols";
    }
    @GetMapping("/deleteProtocol/{id}")
    public String deleteProtocol(@PathVariable("id") Long id){
        System.out.println("Controller: Delete " + id);
        protocolService.deleteById(id);
        return "redirect:/protocols";
    }
    @GetMapping("editProtocol/{id}")
    public String handleEditing(@PathVariable String id){
        System.out.println("Get Edit " + id);
        return "redirect:/protocols";
    }
    @PostMapping("editProtocol/{id}")
    public String editProtocol(@ModelAttribute("protocol") Protocol protocol){
        protocolService.update(protocol);
        System.out.println("Post Edit " + protocol.getId());
        return "redirect:/protocols";
    }



}