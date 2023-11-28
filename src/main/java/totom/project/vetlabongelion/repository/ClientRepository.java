package totom.project.vetlabongelion.repository;

import org.springframework.jdbc.core.RowMapper;
import totom.project.vetlabongelion.model.Client;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    RowMapper<Client> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Client(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("company"));
    };

    List<Client> findAll();
    Optional<Client> findById(Long id);
    List<Client> findAll(String query);
    Client save(Client client);
    Client update(Client client);
    void deleteById(Long id);
}
