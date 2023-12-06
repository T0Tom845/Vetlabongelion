package totom.project.vetlabongelion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import totom.project.vetlabongelion.model.ResearchRequest;
import totom.project.vetlabongelion.repository.ResearchRequestRepository;

import java.util.List;

@Service
public class ResearchRequestService {
    @Autowired
    ResearchRequestRepository researchRequestRepository;

    public List<ResearchRequest> findAll(){
        return researchRequestRepository.findAll();
    }
    public ResearchRequest findById(Long id){
        return researchRequestRepository.findById(id).orElse(null);
    }
    public ResearchRequest save(ResearchRequest protocol){
        return researchRequestRepository.save(protocol);
    }
    public ResearchRequest update(ResearchRequest protocol){
        return researchRequestRepository.update(protocol);
    }
    public void deleteById(Long id){
        researchRequestRepository.deleteById(id);
    }
    public List<ResearchRequest> findAll(String query){
        return researchRequestRepository.findAll(query);
    }
}
