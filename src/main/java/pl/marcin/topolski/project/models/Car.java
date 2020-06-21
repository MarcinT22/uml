package pl.marcin.topolski.project.models;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Integer id;
    private String carBrand;
    private String carModel;
    private Integer year;
    private String registrationNumber;
    @ManyToOne
    private Customer customer;

    public Car() {
    }


    public Car(String carBrand, String carModel, Integer year, String registrationNumber, Customer customer) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.year = year;
        this.registrationNumber = registrationNumber;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public Integer getYear() {
        return year;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", year=" + year +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", customer=" + customer +
                '}';
    }
}
