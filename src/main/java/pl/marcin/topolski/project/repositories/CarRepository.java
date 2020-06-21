package pl.marcin.topolski.project.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.marcin.topolski.project.models.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
