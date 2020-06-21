package pl.marcin.topolski.project.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.marcin.topolski.project.models.Service;

public interface ServiceRepository extends CrudRepository<Service, Integer> {
}
