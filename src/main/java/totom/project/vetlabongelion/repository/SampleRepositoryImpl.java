package totom.project.vetlabongelion.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import totom.project.vetlabongelion.model.Sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SampleRepositoryImpl implements SampleRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Sample> findAll() {
        String sql = "SELECT * FROM vet_sample";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    @Override
    public List<Sample> findAll(String query) {
        String sql = "SELECT * from vet_sample where name SIMILAR TO '%' || ? || '%' " +
                "OR type SIMILAR TO '%' || ? || '%' " +
                "OR amount SIMILAR TO '%' || ? || '%'";
        return new ArrayList<>(jdbcTemplate.query(sql, ROW_MAPPER, query, query, query));
    }

    @Override
    public Optional<Sample> findById(Long id) {
        String sql = "SELECT * FROM vet_sample WHERE id = ?";
        List<Sample> result = jdbcTemplate.query(
                sql, ROW_MAPPER, id);

        return result.size() == 0 ? Optional.empty() : Optional.of(result.get(0));
    }


    @Override
    public Sample save(Sample sample) {
        String sql = "INSERT INTO vet_sample (type, name, amount) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql,
                sample.getType(),
                sample.getName(),
                sample.getAmount());
        return sample;
    }

    @Override
    public Sample update(Sample sample) {
        String sql = "UPDATE vet_sample SET type = ?, name = ?, amount = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                sample.getType(),
                sample.getName(),
                sample.getAmount(),
                sample.getId());
        return sample;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Delete " + id);
        jdbcTemplate.update("DELETE FROM vet_sample WHERE id = ?", id);
    }
}
