package pl.marcin.topolski.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.marcin.topolski.project.models.Car;
import pl.marcin.topolski.project.models.Customer;
import pl.marcin.topolski.project.repositories.CarRepository;
import pl.marcin.topolski.project.repositories.CustomerRepository;


@Controller
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/cars")
    public String getCars(Model model){

        model.addAttribute("cars",carRepository.findAll());

        return "cars";
    }


    @RequestMapping("addCar/{customerId}")
    @ResponseBody
    public String addCar(@PathVariable("customerId") Integer id,
                              @RequestParam(value = "carBrand", defaultValue = "Volskwagen") String carBrand,
                              @RequestParam(value = "carModel", defaultValue = "Polo") String carModel,
                              @RequestParam(value = "year", defaultValue = "2007") Integer year,
                              @RequestParam(value = "registrationNumber", defaultValue = "SCI33322") String registrationNumber) {

        Customer customer = customerRepository.findById(id).orElse(null);
        Car car = new Car(carBrand, carModel, year, registrationNumber,customer);
        carRepository.save(car);


        return "Samochód "+car.getCarBrand()+" "+car.getCarModel()+" został dodany";
    }



}
