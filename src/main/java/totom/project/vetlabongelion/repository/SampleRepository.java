package totom.project.vetlabongelion.repository;

import org.springframework.jdbc.core.RowMapper;
import totom.project.vetlabongelion.model.Sample;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface SampleRepository {
    RowMapper<Sample> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Sample(resultSet.getLong("id"),
                resultSet.getString("type"),
                resultSet.getString("name"),
                resultSet.getLong("amount"));
    };

    List<Sample> findAll();
    Optional<Sample> findById(Long id);
    List<Sample> findAll(String query);
    Sample save(Sample sample);
    Sample update(Sample sample);
    void deleteById(Long id);
}
