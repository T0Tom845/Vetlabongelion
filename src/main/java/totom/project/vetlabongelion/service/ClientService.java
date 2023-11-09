package totom.project.vetlabongelion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import totom.project.vetlabongelion.model.Client;
import totom.project.vetlabongelion.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
    public Client findById(Long id){
        return clientRepository.findById(id).orElse(null);
    }
    public Client save(Client client){
        return clientRepository.save(client);
    }
    public Client update(Client client){
        return clientRepository.update(client);
    }
    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }
}
