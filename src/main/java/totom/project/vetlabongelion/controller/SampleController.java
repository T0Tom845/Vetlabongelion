package totom.project.vetlabongelion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import totom.project.vetlabongelion.model.Sample;
import totom.project.vetlabongelion.service.SampleService;

import java.util.List;

@Controller
@RequestMapping("/samples")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping
    public String showSamples(@RequestParam(value="searchQuery", required = false) String searchQuery, Model model) {
        List<Sample> samples;
        if (searchQuery == null){
            samples = sampleService.findAll();
        }
        else {
            samples = sampleService.findAll(searchQuery);
        }
        model.addAttribute("samples", samples);
        return "samples";
    }
    @PostMapping
    public String saveSample(@ModelAttribute("sample")Sample sample){
        sampleService.save(sample);
        return "redirect:/samples";
    }
    @GetMapping("/deleteSample/{id}")
    public String deleteSample(@PathVariable("id") Long id){
        System.out.println("Controller: Delete " + id);
        sampleService.deleteById(id);
        return "redirect:/samples";
    }
    @GetMapping("editSample/{id}")
    public String handleEditing(@PathVariable String id){
        System.out.println("Get Edit " + id);
        return "redirect:/samples";
    }
    @PostMapping("editSample/{id}")
    public String editSample(@ModelAttribute("sample") Sample sample){
        sampleService.update(sample);
        System.out.println("Post Edit " + sample.getId());
        return "redirect:/samples";
    }



}