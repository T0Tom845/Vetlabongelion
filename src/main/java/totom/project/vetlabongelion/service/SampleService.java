package totom.project.vetlabongelion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import totom.project.vetlabongelion.model.Sample;
import totom.project.vetlabongelion.repository.SampleRepository;

import java.util.List;

@Service
public class SampleService {
    @Autowired
    SampleRepository sampleRepository;

    public List<Sample> findAll(){
        return sampleRepository.findAll();
    }
    public Sample findById(Long id){
        return sampleRepository.findById(id).orElse(null);
    }
    public Sample save(Sample protocol){
        return sampleRepository.save(protocol);
    }
    public Sample update(Sample protocol){
        return sampleRepository.update(protocol);
    }
    public void deleteById(Long id){
        sampleRepository.deleteById(id);
    }
    public List<Sample> findAll(String query){
        return sampleRepository.findAll(query);
    }
}
