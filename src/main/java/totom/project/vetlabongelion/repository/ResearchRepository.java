package totom.project.vetlabongelion.repository;

import org.springframework.jdbc.core.RowMapper;
import totom.project.vetlabongelion.model.Research;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface ResearchRepository {
    RowMapper<Research> ROW_MAPPER = (ResultSet resultSet, int rowNum) ->
            new Research(resultSet.getLong("res_id")
            ,resultSet.getLong("res_type_id")
            ,resultSet.getLong("res_prot_id")
            ,resultSet.getDate("res_date")
            ,resultSet.getLong("id_res_request"));

    List<Research> findAll();
    Optional<Research> findById(Long id);
    List<Research> findAll(String query);
    Research save(Research research);
    Research update(Research research);
    void deleteById(Long id);
}
