package totom.project.vetlabongelion.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;
import totom.project.vetlabongelion.model.Client;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClientRepositoryImpl implements ClientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Client> findAll() {
        String sql = "SELECT * FROM vet_client";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
    @Override
    public List<Client> findAll(String query) {
        String sql = "SELECT * from vet_client where name SIMILAR TO '%' || ? || '%' " +
                "OR company SIMILAR TO '%' || ? || '%'";
        return new ArrayList<>(jdbcTemplate.query(sql, ROW_MAPPER , query, query));
    }

    @Override
    public Optional<Client> findById(Long id) {
        String sql = "SELECT * FROM vet_client WHERE id = ?";
        List<Client> result =jdbcTemplate.query(
                sql, ROW_MAPPER, id);

        return result.size() == 0? Optional.empty() : Optional.of(result.get(0));
    }



    @Override
    public Client save(Client client) {
        String sql = "INSERT INTO vet_client (name, company) VALUES(?, ?)";
        jdbcTemplate.update(sql,
                client.getName(),
                client.getCompany());
                client.getId();
        return client;
    }

    @Override
    public Client update(Client client) {
        String sql = "UPDATE vet_client SET name = ?, company = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                client.getName(),
                client.getCompany(),
                client.getId());
        return client;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Delete " + id);
        jdbcTemplate.update("DELETE FROM vet_client WHERE id = ?", id);
    }
}
