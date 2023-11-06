package totom.project.vetlabongelion.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.config.Task;
import totom.project.vetlabongelion.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ClientRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();

        client.setId(rs.getLong(Client.Fields.id));
        client.setName(rs.getString(Client.Fields.name));
        client.setCompany(rs.getString(Client.Fields.company));

        return client;
    }
}
