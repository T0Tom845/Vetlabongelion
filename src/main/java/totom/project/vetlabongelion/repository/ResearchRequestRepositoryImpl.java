package totom.project.vetlabongelion.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import totom.project.vetlabongelion.model.ResearchRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ResearchRequestRepositoryImpl implements ResearchRequestRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ResearchRequest> findAll() {
        String sql = "SELECT * FROM vet_research_request";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    @Override
    public List<ResearchRequest> findAll(String query) {
        String sql =
                "SELECT * from vet_research_request where rere_emp_id SIMILAR TO '%' || ? || '%' " +
                        "OR rere_client_id SIMILAR TO '%' || ? || '%' " +
                        "OR rere_date SIMILAR TO '%' || ? || '%' " +
                        "OR rere_samp_id SIMILAR TO '%' || ? || '%' ";
        return new ArrayList<>(jdbcTemplate.query(sql, ROW_MAPPER, query, query, query, query));
    }

    @Override
    public Optional<ResearchRequest> findById(Long id) {
        String sql = "SELECT * FROM vet_research_request WHERE rere_id = ?";
        List<ResearchRequest> result = jdbcTemplate.query(
                sql, ROW_MAPPER, id);

        return result.size() == 0 ? Optional.empty() : Optional.of(result.get(0));
    }


    @Override
    public ResearchRequest save(ResearchRequest researchRequest) {
        String sql = "INSERT INTO vet_research_request (rere_emp_id, rere_client_id, rere_date, rere_samp_id) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,
                researchRequest.getEmployeeId(),
                researchRequest.getClientId(),
                researchRequest.getDate(),
                researchRequest.getSampleId());
        return researchRequest;
    }

    @Override
    public ResearchRequest update(ResearchRequest researchRequest) {
        String sql = "UPDATE vet_research_request SET rere_emp_id = ?, rere_client_id = ?, rere_date = ?, rere_samp_id = ? WHERE rere_id = ?";
        jdbcTemplate.update(sql,
                researchRequest.getEmployeeId(),
                researchRequest.getClientId(),
                researchRequest.getDate(),
                researchRequest.getSampleId(),
                researchRequest.getId());
        return researchRequest;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Delete " + id);
        jdbcTemplate.update("DELETE FROM vet_research_request WHERE rere_id = ?", id);
    }
}
