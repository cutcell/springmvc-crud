package com.javamentor.service;

import com.javamentor.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer id);

    Customer createOrUpdateCustomer(Customer customer);

    void deleteCustomer(Integer id);

}
