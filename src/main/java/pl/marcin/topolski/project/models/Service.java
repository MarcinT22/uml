package pl.marcin.topolski.project.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Service {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private Integer cost;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Service() {
    }

    public Service(String description, Integer cost, Car car) {
        this.description = description;
        this.cost = cost;
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCost() {
        return cost;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", car=" + car +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
