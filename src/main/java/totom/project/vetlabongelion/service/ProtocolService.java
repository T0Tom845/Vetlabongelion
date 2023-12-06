package totom.project.vetlabongelion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import totom.project.vetlabongelion.model.Protocol;
import totom.project.vetlabongelion.repository.ProtocolRepository;

import java.util.List;
@Service
public class ProtocolService {
    @Autowired
    ProtocolRepository protocolRepository;

    public List<Protocol> findAll(){
        return protocolRepository.findAll();
    }
    public Protocol findById(Long id){
        return protocolRepository.findById(id).orElse(null);
    }
    public Protocol save(Protocol protocol){
        return protocolRepository.save(protocol);
    }
    public Protocol update(Protocol protocol){
        return protocolRepository.update(protocol);
    }
    public void deleteById(Long id){
        protocolRepository.deleteById(id);
    }
    public List<Protocol> findAll(String query){
        return protocolRepository.findAll(query);
    }
}
