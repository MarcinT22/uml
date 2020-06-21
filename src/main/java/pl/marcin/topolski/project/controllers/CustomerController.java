package pl.marcin.topolski.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.marcin.topolski.project.models.Customer;
import pl.marcin.topolski.project.repositories.CustomerRepository;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @GetMapping("/")
    public String getCustomers(Model model){

        model.addAttribute("customers",customerRepository.findAll());

        return "customers";
    }

    @RequestMapping("addCustomer")
    @ResponseBody
    public String addCustomer(@RequestParam(value = "firstName",defaultValue = "Marcin") String firstName,
                              @RequestParam(value = "lastName",defaultValue = "Topolski") String lastName,
                              @RequestParam(value = "phone",defaultValue = "123456789") Integer phone
                              ){
        Customer customer = new Customer(firstName, lastName, phone);
        customerRepository.save(customer);

        return "Klient "+customer.getFirstName()+" "+customer.getLastName()+" został dodany";
    }
}
