package com.example.customerapi.controllers;

import com.example.customerapi.dto.CustomerDto;
import com.example.customerapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CustomerController {

    private CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers")
    public ResponseEntity<List<CustomerDto>> getCustomers() {

        return new  ResponseEntity <> (customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("customers/{Id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Integer Id) {
        return new ResponseEntity<>(customerService.getCustomerById(Id), HttpStatus.OK);
    }

    @PostMapping("customers")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDto> setCustomer(@RequestBody CustomerDto customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }


}
