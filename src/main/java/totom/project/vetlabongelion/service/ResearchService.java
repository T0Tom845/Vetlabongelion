package totom.project.vetlabongelion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import totom.project.vetlabongelion.model.Research;
import totom.project.vetlabongelion.repository.ResearchRepository;

import java.util.List;

@Service
public class ResearchService {
    @Autowired
    ResearchRepository researchRepository;

    public List<Research> findAll(){
        return researchRepository.findAll();
    }
    public Research findById(Long id){
        return researchRepository.findById(id).orElse(null);
    }
    public Research save(Research protocol){
        return researchRepository.save(protocol);
    }
    public Research update(Research protocol){
        return researchRepository.update(protocol);
    }
    public void deleteById(Long id){
        researchRepository.deleteById(id);
    }
    public List<Research> findAll(String query){
        return researchRepository.findAll(query);
    }
}
