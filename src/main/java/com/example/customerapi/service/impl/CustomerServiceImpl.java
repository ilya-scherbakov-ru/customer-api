package com.example.customerapi.service.impl;

import com.example.customerapi.dto.CustomerDto;
import com.example.customerapi.exceptions.CustomerNotFoundException;
import com.example.customerapi.models.Customer;
import com.example.customerapi.repository.CustomerRepository;
import com.example.customerapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer (CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustomerId(customer.getCustomerId());
        customer.setRegion(customerDto.getRegion());


        Customer newCustomer = customerRepository.save(customer);

        CustomerDto customerResponse = new CustomerDto();
        customerResponse.setCustomerId(newCustomer.getCustomerId());
        customerResponse.setRegion(newCustomer.getRegion());



        return customerResponse;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customer = customerRepository.findAll();
        return customer.stream().map(mappedCustomer -> mapToDto(mappedCustomer)).collect(Collectors.toList());
    }


    @Override
    public CustomerDto getCustomerById (Integer Id) {
        Customer customer = customerRepository.findById(Id).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        return mapToDto(customer);
    }
    private CustomerDto mapToDto (Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setRegion(customer.getRegion());// + "__111");
        return  customerDto;
    }

    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setRegion(customerDto.getRegion());
        return customer;
    }



}
