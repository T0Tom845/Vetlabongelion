package totom.project.vetlabongelion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import totom.project.vetlabongelion.model.Protocol;
import totom.project.vetlabongelion.model.Research;
import totom.project.vetlabongelion.model.ResearchRequest;
import totom.project.vetlabongelion.model.ResearchType;
import totom.project.vetlabongelion.service.ProtocolService;
import totom.project.vetlabongelion.service.ResearchRequestService;
import totom.project.vetlabongelion.service.ResearchService;
import totom.project.vetlabongelion.service.ResearchTypeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/researches")
public class ResearchController {

    private final ResearchService researchService;
    private final ResearchRequestService requestService;
    private final ResearchTypeService researchTypeService;
    private final ProtocolService protocolService;

    public ResearchController(ResearchService researchService,
                              ResearchRequestService requestService,
                              ResearchTypeService researchTypeService,
                              ProtocolService protocolService) {
        this.researchService = researchService;
        this.requestService = requestService;
        this.researchTypeService = researchTypeService;
        this.protocolService = protocolService;
    }

    @GetMapping
    public String showResearches(@RequestParam(value="searchQuery", required = false) String searchQuery, Model model) {
        List<Research> researches;
        List<ResearchRequest> researchRequests;
        List<ResearchType> researchTypes;
        List<Protocol> protocols;
        if (searchQuery == null){
            researches = researchService.findAll();
        }
        else {
            researches = researchService.findAll(searchQuery);
        }
        researchRequests = requestService.findAll();
        researchTypes = researchTypeService.findAll();
        protocols = protocolService.findAll();
        Map<String, List<?>> attributesMap = new HashMap<>();
        attributesMap.put("researches", researches);
        attributesMap.put("researchRequests", researchRequests);
        attributesMap.put("researchTypes", researchTypes);
        attributesMap.put("protocols", protocols);
        model.addAllAttributes(attributesMap);
        return "researches";
    }
    @PostMapping
    public String saveResearch(@ModelAttribute("research")Research research){
        researchService.save(research);
        return "redirect:/researches";
    }
    @GetMapping("/deleteResearch/{id}")
    public String deleteResearch(@PathVariable("id") Long id){
        System.out.println("Controller: Delete " + id);
        researchService.deleteById(id);
        return "redirect:/researches";
    }
    @GetMapping("editResearch/{id}")
    public String handleEditing(@PathVariable String id){
        System.out.println("Get Edit " + id);
        return "redirect:/researches";
    }
    @PostMapping("editResearch/{id}")
    public String editResearch(@ModelAttribute("research") Research research){
        researchService.update(research);
        System.out.println("Post Edit " + research.getId());
        return "redirect:/researches";
    }



}