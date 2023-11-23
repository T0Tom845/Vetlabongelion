package totom.project.vetlabongelion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import totom.project.vetlabongelion.model.Client;
import totom.project.vetlabongelion.service.ClientService;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String showClients(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "clients";
    }
    @PostMapping
    public String saveClient(@ModelAttribute("client")Client client){
        clientService.save(client);
        return "redirect:/clients";
    }
    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable("id") Long id){
        System.out.println("Controller: Delete " + id);
        clientService.deleteById(id);
        return "redirect:/clients";
    }
    @GetMapping("editClient/{id}")
    public String handleEditing(@PathVariable String id){
        System.out.println("Get Edit " + id);
        return "redirect:/clients";
    }
    @PostMapping("editClient/{id}")
    public String editClient(@ModelAttribute("client") Client client){

        clientService.update(client);
        System.out.println("Post Edit " + client.getId());
        return "redirect:/clients";
    }

}