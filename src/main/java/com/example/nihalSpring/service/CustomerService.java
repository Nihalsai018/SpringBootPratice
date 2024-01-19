package com.example.nihalSpring.service;

import com.example.nihalSpring.dao.CustomerDAO;
import com.example.nihalSpring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }


    public List<Customer> getCustomerList() {
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerId) {
        return customerDAO.findById(customerId).orElse(null);
    }

    public Customer updateCustomer(int customerId, Customer customer) {
        if (customerDAO.existsById(customerId)) {
            customer.setCustomerId(customerId);
            return customerDAO.save(customer);
        } else {
            // Handle the case where the customer with the given ID does not exist
            return null;
        }
    }

    public void deleteCustomer(int customerId)   {
        customerDAO.deleteById(customerId);
    }
}






//package com.example.nihalSpring.service;
//
//import com.example.nihalSpring.dao.CustomerDAO;
//import com.example.nihalSpring.model.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//@Component // to provide services to cutomer class
//public class CustomerService {
//
//    @Autowired
//    private CustomerDAO customerDAO;
//
//    private int customerIdCount=1;
//    private List<Customer> customerList =new CopyOnWriteArrayList<>();
//
//
//    public Customer addCustomer(Customer customer){
//       // customer.setCustomerId(customerIdCount);
////        customerList.add(customer);
////                customerIdCount++;
////        return customer;
//
//        return customerDAO.save(customer); // save recods of customers
//
//    }
//
//    public List<Customer> getCustomerList() {
//      return   customerDAO.findAll(); // it return iterable customers
//     //   return customerList;
//    }
//
//    public Customer getCustomer(int customerId){
////      return   customerList.stream()
////                .filter(c -> c.getCustomerId() == customerId)
////                .findFirst()
////                .get();
//
//
//       return customerDAO.findById(customerId).get(); // customer list  getby id we use optional interface  if we pass out of box we not get null
//
//
//    }
//
//    public  Customer updateCustomer(int customerId, Customer customer){
////      customerList.stream()
////              .forEach(c ->{
////                  if (c.getCustomerId() == customerId){
////                      c.setCustomerFirstName(customer.getCustomerFirstName());
////                      c.setCustomerLastName(customer.getCustomerLastName());
////                      c.setCustomerEmail(customer.getCustomerEmail());
////
////                  }
////              });
////      return customerList
////              .stream()
////              .filter(c -> c.getCustomerId() == customerId)
////              .findFirst()
////              .get();
//
//        customer.setCustomerId(customerId);
//
//      return   customerDAO.save(customer);
//    }
//
//    public void deleteCustomer( int customerId){
////        customerList
////                .stream()
////                .forEach(c -> {
////                    if (c.getCustomerId()==customerId) {
////                        customerList.remove(c);
////                    }
////                });
//
//        customerDAO.deleteById(customerId);
//
//
//    }
//
//}
