package totom.project.vetlabongelion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import totom.project.vetlabongelion.model.Research;
import totom.project.vetlabongelion.service.ResearchService;

import java.util.List;

@Controller
@RequestMapping("/researches")
public class ResearchController {

    @Autowired
    private ResearchService researchService;

    @GetMapping
    public String showResearches(@RequestParam(value="searchQuery", required = false) String searchQuery, Model model) {
        List<Research> researches;
        if (searchQuery == null){
            researches = researchService.findAll();
        }
        else {
            researches = researchService.findAll(searchQuery);
        }
        model.addAttribute("researches", researches);
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