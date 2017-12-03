package com.javamentor.service;

import com.javamentor.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }


    @Override
    public List<Customer> getAllCustomers() {

        return new ArrayList<>(customers.values());

    }

    @Override
    public Customer getCustomerById(Integer id) {

        return customers.get(id);

    }

    @Override
    public Customer createOrUpdateCustomer(Customer customer) {

        if (customer == null) {
            throw new IllegalArgumentException("Customer cant be null");
        }

        if (customer.getId() == null) {
            customer.setId(getNextId());
        }

        customers.put(customer.getId(), customer);

        return customer;

    }

    @Override
    public void deleteCustomer(Integer id) {

        customers.remove(id);

    }

    private Integer getNextId() {
        return Collections.max(customers.keySet()) + 1;
    }

    private void loadCustomers() {

        customers = new HashMap<>();
        Customer c = new Customer();
        c.setId(1);
        c.setFullName("admin");
        c.setEmail("admin@admin");

        customers.put(1, c);

        c = new Customer();
        c.setId(2);
        c.setFullName("user");
        c.setEmail("user@user");

        customers.put(2, c);

    }
}
