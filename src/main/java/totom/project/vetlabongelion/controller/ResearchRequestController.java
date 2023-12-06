package totom.project.vetlabongelion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import totom.project.vetlabongelion.model.Research;
import totom.project.vetlabongelion.model.ResearchRequest;
import totom.project.vetlabongelion.service.ResearchRequestService;

import java.util.List;

@Controller
@RequestMapping("/research-requests")
public class ResearchRequestController {

    @Autowired
    private ResearchRequestService researchRequestService;

    @GetMapping
    public String showResearchRequests(@RequestParam(value="searchQuery", required = false) String searchQuery, Model model) {
        List<ResearchRequest> researchRequests;
        if (searchQuery == null){
            researchRequests = researchRequestService.findAll();
        }
        else {
            researchRequests = researchRequestService.findAll(searchQuery);
        }
        model.addAttribute("researchRequests", researchRequests);
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