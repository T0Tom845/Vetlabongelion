package totom.project.vetlabongelion.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import totom.project.vetlabongelion.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM vet_employee";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
    @Override
    public List<Employee> findAll(String query) {
        String sql = "SELECT * from vet_employee where emp_name SIMILAR TO '%' || ? || '%' " +
                "OR emp_job_title SIMILAR TO '%' || ? || '%' " +
                "OR emp_dep_id SIMILAR TO '%' || ? || '%' ";
        return new ArrayList<>(jdbcTemplate.query(sql, ROW_MAPPER , query, query, query));
    }

    @Override
    public Optional<Employee> findById(Long id) {
        String sql = "SELECT * FROM vet_employee WHERE emp_id = ?";
        List<Employee> result =jdbcTemplate.query(
                sql, ROW_MAPPER, id);

        return result.size() == 0? Optional.empty() : Optional.of(result.get(0));
    }



    @Override
    public Employee save(Employee employee) {
        String sql = "INSERT INTO vet_employee (emp_name, emp_job_title, emp_dep_id) VALUES(?,?,?)";
        jdbcTemplate.update(sql,
                employee.getName(),
                employee.getJobTitle(),
                employee.getDepId());
                employee.getId();
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        String sql = "UPDATE vet_employee SET emp_name = ?, emp_job_title = ?, emp_dep_id = ? WHERE emp_id = ?";
        jdbcTemplate.update(sql,
                employee.getName(),
                employee.getJobTitle(),
                employee.getDepId(),
                employee.getId());
        return employee;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Delete " + id);
        jdbcTemplate.update("DELETE FROM vet_employee WHERE emp_id = ?", id);
    }
}
