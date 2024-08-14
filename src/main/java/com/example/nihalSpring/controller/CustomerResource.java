package com.example.nihalSpring.controller;

import com.example.nihalSpring.model.Customer;
import com.example.nihalSpring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customerController")
public class CustomerResource {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/saverecords")
    public Customer addCustomer( @RequestBody Customer customer) throws InterruptedException { // who this responsible to call this api

        System.out.println("starting sleep");
        Thread.sleep(5000l);
        System.out.println("Sleep done");
        return customerService.addCustomer(customer);

    }
    @GetMapping("/getrecords")
    public List<Customer> getCustomer(){
        return  customerService.getCustomerList();
    }
    @GetMapping(value = "getrecordById/{customerID}")
    public Customer getCustomer(@PathVariable("customerID") int customerID){
        return customerService.getCustomer(customerID);
    }

    @PutMapping(value = "/{customerId}")
    public Customer UpdateCustomer(@PathVariable("customerId") int customerId ,@RequestBody Customer customer){
        return customerService.updateCustomer(customerId ,customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
    }
}
