package pl.marcin.topolski.project.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.marcin.topolski.project.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
