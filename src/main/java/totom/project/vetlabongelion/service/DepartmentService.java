package totom.project.vetlabongelion.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import totom.project.vetlabongelion.model.Department;
import totom.project.vetlabongelion.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {
    final DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
    public Department findById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }
    public Department save(Department department){
        return departmentRepository.save(department);
    }
    public Department update(Department department){
        return departmentRepository.update(department);
    }
    public void deleteById(Long id){
        departmentRepository.deleteById(id);
    }
    public List<Department> findAll(String query){
        return departmentRepository.findAll(query);
    }
}
