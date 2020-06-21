package pl.marcin.topolski.project.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer phone;
    @OneToMany(mappedBy = "customer")
    private Set<Car> cars = new HashSet<>();

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }


    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPhone() {
        return phone;
    }

    public Set<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", cars=" + cars +
                '}';
    }
}
