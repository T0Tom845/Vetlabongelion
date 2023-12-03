package totom.project.vetlabongelion.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import totom.project.vetlabongelion.model.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM vet_department";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
    @Override
    public List<Department> findAll(String query) {
        String sql = "SELECT * from vet_department where dep_name SIMILAR TO '%' || ? || '%' ";
        return new ArrayList<>(jdbcTemplate.query(sql, ROW_MAPPER , query));
    }

    @Override
    public Optional<Department> findById(Long id) {
        String sql = "SELECT * FROM vet_department WHERE dep_id = ?";
        List<Department> result =jdbcTemplate.query(
                sql, ROW_MAPPER, id);

        return result.size() == 0? Optional.empty() : Optional.of(result.get(0));
    }



    @Override
    public Department save(Department department) {
        String sql = "INSERT INTO vet_department (dep_name) VALUES(?)";
        jdbcTemplate.update(sql,
                department.getName());
                department.getId();
        return department;
    }

    @Override
    public Department update(Department department) {
        String sql = "UPDATE vet_department SET dep_name = ? WHERE dep_id = ?";
        jdbcTemplate.update(sql,
                department.getName(),
                department.getId());
        return department;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Delete " + id);
        jdbcTemplate.update("DELETE FROM vet_department WHERE dep_id = ?", id);
    }
}
