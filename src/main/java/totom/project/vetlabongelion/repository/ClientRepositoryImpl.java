package totom.project.vetlabongelion.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import totom.project.vetlabongelion.model.Client;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClientRepositoryImpl implements ClientRepository{

     private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Client> findAll() {
        String sql = "SELECT * FROM vet_client";
        return jdbcTemplate.query(sql, new ClientRowMapper());
    }

    @Override
    public Optional<Client> findById() {
        return Optional.empty();
    }
}
