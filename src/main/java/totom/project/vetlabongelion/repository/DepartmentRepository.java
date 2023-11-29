package totom.project.vetlabongelion.repository;

import org.springframework.jdbc.core.RowMapper;
import totom.project.vetlabongelion.model.Department;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {
    RowMapper<Department> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Department(resultSet.getLong("dep_id"), resultSet.getString("dep_name"));
    };

    List<Department> findAll();
    Optional<Department> findById(Long id);
    List<Department> findAll(String query);
    Department save(Department department);
    Department update(Department department);
    void deleteById(Long id);
}
