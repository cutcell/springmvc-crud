package com.javamentor.controller;

import com.javamentor.domain.Customer;
import com.javamentor.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String listCustomers(Model model) {

        model.addAttribute("customers", customerService.getAllCustomers());

        return "customers";

    }

    @RequestMapping("/customer/new")
    public String createCustomer(Model model) {

        model.addAttribute("customer", new Customer());

        return "customerform";

    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String createOrUpdateCustomer(Customer customer) {

        customerService.createOrUpdateCustomer(customer);

        return "redirect:/customers";

    }

    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {

        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);

        return "customerform";

    }

    @RequestMapping("customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {

        customerService.deleteCustomer(id);
        return "redirect:/customers";

    }


}
