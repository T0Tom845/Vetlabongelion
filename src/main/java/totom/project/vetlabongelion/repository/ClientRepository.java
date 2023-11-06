package totom.project.vetlabongelion.repository;

import org.springframework.data.repository.CrudRepository;
import totom.project.vetlabongelion.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> findAll();
    Optional<Client> findById();
}
