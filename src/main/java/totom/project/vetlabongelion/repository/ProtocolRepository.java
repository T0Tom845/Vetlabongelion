package totom.project.vetlabongelion.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.bind.annotation.InitBinder;
import totom.project.vetlabongelion.model.Protocol;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
public interface ProtocolRepository {
    RowMapper<Protocol> ROW_MAPPER = (ResultSet resultSet, int rowNum) ->
            new Protocol(resultSet.getLong("prot_id")
            ,resultSet.getLong("prot_cli_id")
            ,resultSet.getDate("prot_date")
            ,resultSet.getLong("prot_emp_id"));

    List<Protocol> findAll();
    Optional<Protocol> findById(Long id);
    List<Protocol> findAll(String query);
    Protocol save(Protocol protocol);
    Protocol update(Protocol protocol);
    void deleteById(Long id);
}
