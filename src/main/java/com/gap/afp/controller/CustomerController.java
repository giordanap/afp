package com.gap.afp.controller;


import com.gap.afp.model.entity.Customer;
import com.gap.afp.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(){
        LOGGER.info("Made the listing request");
        return customerRepository.findAll();
    }

    @PostMapping("/newCustomer")
    @ResponseStatus(HttpStatus.OK)
    public void createCustomer(@RequestBody Customer customer ){
        LOGGER.info("Made the request again");
        customerRepository.save(customer);
    }

    @GetMapping("/oneCustomer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(value = "id") String id){
        LOGGER.info("Made the id request");
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customer.get(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") String id) {
        LOGGER.info("Made the delete request by Id");
        customerRepository.deleteById(id);
        return "Customer deleted";
    }

    @PutMapping("/update/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable(value = "id") String id){
        LOGGER.info("Made the update request by Id");
        customer.setIdCustomer(id);
        customerRepository.save(customer);
        return customer;
    }
}
