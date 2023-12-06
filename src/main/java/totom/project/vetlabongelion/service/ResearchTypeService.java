package totom.project.vetlabongelion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import totom.project.vetlabongelion.model.ResearchType;
import totom.project.vetlabongelion.repository.ResearchTypeRepository;

import java.util.List;

@Service
public class ResearchTypeService {
    @Autowired
    ResearchTypeRepository researchTypeRepository;

    public List<ResearchType> findAll(){
        return researchTypeRepository.findAll();
    }
    public ResearchType findById(Long id){
        return researchTypeRepository.findById(id).orElse(null);
    }
    public ResearchType save(ResearchType researchType){
        return researchTypeRepository.save(researchType);
    }
    public ResearchType update(ResearchType researchType){
        return researchTypeRepository.update(researchType);
    }
    public void deleteById(Long id){
        researchTypeRepository.deleteById(id);
    }
    public List<ResearchType> findAll(String query){
        return researchTypeRepository.findAll(query);
    }
}
