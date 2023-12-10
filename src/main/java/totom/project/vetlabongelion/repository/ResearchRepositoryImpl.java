package totom.project.vetlabongelion.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import totom.project.vetlabongelion.model.Research;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ResearchRepositoryImpl implements ResearchRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Research> findAll() {
        String sql = "SELECT * FROM vet_research";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    @Override
    public List<Research> findAll(String query) {
        String sql =
                "SELECT * from vet_research where res_type_id SIMILAR TO '%' || ? || '%' " +
                        "OR res_prot_id SIMILAR TO '%' || ? || '%' " +
                        "OR res_date SIMILAR TO '%' || ? || '%' " +
                        "OR res_request_id SIMILAR TO '%' || ? || '%' ";
        return new ArrayList<>(jdbcTemplate.query(sql, ROW_MAPPER, query, query, query, query));
    }

    @Override
    public Optional<Research> findById(Long id) {
        String sql = "SELECT * FROM vet_research WHERE res_id = ?";
        List<Research> result = jdbcTemplate.query(
                sql, ROW_MAPPER, id);

        return result.size() == 0 ? Optional.empty() : Optional.of(result.get(0));
    }


    @Override
    public Research save(Research research) {
        String sql = "INSERT INTO vet_research (res_type_id, res_prot_id, res_date, res_request_id) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,
                research.getTypeId(),
                research.getProtId(),
                research.getDate(),
                research.getRequestId());
        return research;
    }

    @Override
    public Research update(Research research) {
        String sql = "UPDATE vet_research SET res_type_id = ?, res_prot_id = ?, res_date = ?, res_request_id = ? WHERE res_id = ?";
        jdbcTemplate.update(sql,
                research.getTypeId(),
                research.getProtId(),
                research.getDate(),
                research.getRequestId(),
                research.getId());
        return research;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Delete " + id);
        jdbcTemplate.update("DELETE FROM vet_research WHERE res_id = ?", id);
    }
}
