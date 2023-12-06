package totom.project.vetlabongelion.repository;

import org.springframework.jdbc.core.RowMapper;
import totom.project.vetlabongelion.model.ResearchType;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface ResearchTypeRepository {
    RowMapper<ResearchType> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new ResearchType(resultSet.getLong("restyp_id"),
                resultSet.getString("research_type"),
                resultSet.getLong("restyp_dep_id"));
    };

    List<ResearchType> findAll();
    Optional<ResearchType> findById(Long id);
    List<ResearchType> findAll(String query);
    ResearchType save(ResearchType researchType);
    ResearchType update(ResearchType researchType);
    void deleteById(Long id);
}
