package totom.project.vetlabongelion.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import totom.project.vetlabongelion.model.ResearchType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ResearchTypeRepositoryImpl implements ResearchTypeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ResearchType> findAll() {
        String sql = "SELECT * FROM vet_research_type";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
    @Override
    public List<ResearchType> findAll(String query) {
        String sql = "SELECT * from vet_research_type where research_type SIMILAR TO '%' || ? || '%' " +
                "OR restyp_dep_id SIMILAR TO '%' || ? || '%'";
        return new ArrayList<>(jdbcTemplate.query(sql, ROW_MAPPER , query, query));
    }

    @Override
    public Optional<ResearchType> findById(Long id) {
        String sql = "SELECT * FROM vet_research_type WHERE restyp_id = ?";
        List<ResearchType> result =jdbcTemplate.query(
                sql, ROW_MAPPER, id);

        return result.size() == 0? Optional.empty() : Optional.of(result.get(0));
    }



    @Override
    public ResearchType save(ResearchType researchType) {
        String sql = "INSERT INTO vet_research_type (research_type, restyp_dep_id) VALUES(?, ?)";
        jdbcTemplate.update(sql,
                researchType.getType(),
                researchType.getDepartmentId());
        return researchType;
    }

    @Override
    public ResearchType update(ResearchType researchType) {
        String sql = "UPDATE vet_research_type SET research_type = ?, restyp_dep_id = ? WHERE restyp_id = ?";
        jdbcTemplate.update(sql,
                researchType.getType(),
                researchType.getDepartmentId(),
                researchType.getId());
        return researchType;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Delete " + id);
        jdbcTemplate.update("DELETE FROM vet_research_type WHERE restyp_id = ?", id);
    }
}
