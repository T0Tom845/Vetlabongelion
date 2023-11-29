package totom.project.vetlabongelion.repository;

import org.springframework.jdbc.core.RowMapper;
import totom.project.vetlabongelion.model.Employee;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    RowMapper<Employee> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Employee(resultSet.getLong("emp_id")
                ,resultSet.getString("emp_name")
                ,resultSet.getString("emp_job_title")
                ,resultSet.getLong("emp_dep_id"));
    };

    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    List<Employee> findAll(String query);
    Employee save(Employee employee);
    Employee update(Employee employee);
    void deleteById(Long id);
}
