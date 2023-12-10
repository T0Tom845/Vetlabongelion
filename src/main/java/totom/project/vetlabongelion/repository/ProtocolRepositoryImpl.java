package totom.project.vetlabongelion.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import totom.project.vetlabongelion.model.Protocol;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProtocolRepositoryImpl implements ProtocolRepository {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Protocol> findAll() {
        String sql = "SELECT * FROM vet_protocol";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
    @Override
    public List<Protocol> findAll(String query) {
        String sql =
                "SELECT * from vet_protocol where prot_cli_id SIMILAR TO '%' || ? || '%' " +
                "OR prot_date SIMILAR TO '%' || ? || '%' "+
                "OR prot_emp_id SIMILAR TO '%' || ? || '%' " ;
        return new ArrayList<>(jdbcTemplate.query(sql, ROW_MAPPER , query, query, query));//TODO: Как то надо починить поиск
    }

    @Override
    public Optional<Protocol> findById(Long id) {
        String sql = "SELECT * FROM vet_protocol WHERE prot_id = ?";
        List<Protocol> result = jdbcTemplate.query(
                sql, ROW_MAPPER, id);

        return result.size() == 0? Optional.empty() : Optional.of(result.get(0));
    }



    @Override
    public Protocol save(Protocol protocol) {
        String sql = "INSERT INTO vet_protocol (prot_cli_id, prot_date, prot_emp_id) VALUES(?,?,?)";
        jdbcTemplate.update(sql,
                protocol.getClientId(),
                protocol.getDate(),
                protocol.getEmployeeId());
        return protocol;
    }

    @Override
    public Protocol update(Protocol protocol) {
        String sql = "UPDATE vet_protocol SET prot_cli_id = ?, prot_date = ?, prot_emp_id = ? WHERE prot_id = ?";
        jdbcTemplate.update(sql,
                protocol.getClientId(),
                protocol.getDate(),
                protocol.getEmployeeId(),
                protocol.getId());
        return protocol;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Delete " + id);
        jdbcTemplate.update("DELETE FROM vet_protocol WHERE prot_id = ?", id);
    }
}
