package totom.project.vetlabongelion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import totom.project.vetlabongelion.model.Employee;
import totom.project.vetlabongelion.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    public Employee findById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee update(Employee employee){
        return employeeRepository.update(employee);
    }
    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }
    public List<Employee> findAll(String query){
        return employeeRepository.findAll(query);
    }
}
