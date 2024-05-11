package org.example.jp2.controller;

import org.example.jp2.model.Customer;
import org.example.jp2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {

        Customer savedCustomer = null;
        ResponseEntity<String> response = null;
        try{

            savedCustomer = customerRepository.save(customer);

            if(savedCustomer.getId()>0){
                response=ResponseEntity.status(HttpStatus.CREATED).body("Customer successfully registered!");
            }

        }catch (Exception e){

            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("exception occurred: "+ e.getMessage());
        }
        return response;
    }
}
