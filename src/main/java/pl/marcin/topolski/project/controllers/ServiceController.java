package pl.marcin.topolski.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.marcin.topolski.project.models.Car;
import pl.marcin.topolski.project.models.Service;
import pl.marcin.topolski.project.repositories.CarRepository;
import pl.marcin.topolski.project.repositories.ServiceRepository;

import java.util.Optional;

@Controller
public class ServiceController {


    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    CarRepository carRepository;


    @GetMapping("/services")
    public String getServices(Model model){

        model.addAttribute("services",serviceRepository.findAll());

        return "services";
    }

    @RequestMapping("addService/{carId}")
    @ResponseBody
    public String addServices(@PathVariable("carId") Integer id,
                              @RequestParam(value = "description",defaultValue = "Wymiana oleju") String description,
                              @RequestParam(value = "cost",defaultValue = "100") Integer cost)
    {
        Car car = carRepository.findById(id).orElse(null);
        Service service = new Service(description,cost,car);
        serviceRepository.save(service);


        return "Zapisano usługę";
    }
}
