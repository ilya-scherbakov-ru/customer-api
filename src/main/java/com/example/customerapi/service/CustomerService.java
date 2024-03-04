package com.example.customerapi.service;

import com.example.customerapi.dto.CustomerDto;


import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer (CustomerDto customerDto);
    CustomerDto getCustomerById(Integer Id);
    List<CustomerDto> getAllCustomers();

}
