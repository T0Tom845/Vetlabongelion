package totom.project.vetlabongelion.repository;

import org.springframework.jdbc.core.RowMapper;
import totom.project.vetlabongelion.model.ResearchRequest;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface ResearchRequestRepository {
    RowMapper<ResearchRequest> ROW_MAPPER = (ResultSet resultSet, int rowNum) ->
            new ResearchRequest(resultSet.getLong("rere_id")
            ,resultSet.getLong("rere_emp_id")
            ,resultSet.getLong("rere_client_id")
            ,resultSet.getDate("rere_date")
            ,resultSet.getLong("rere_samp_id"));

    List<ResearchRequest> findAll();
    Optional<ResearchRequest> findById(Long id);
    List<ResearchRequest> findAll(String query);
    ResearchRequest save(ResearchRequest researchRequest);
    ResearchRequest update(ResearchRequest researchRequest);
    void deleteById(Long id);
}
