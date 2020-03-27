package com.hibernate.controller;


import com.hibernate.dao.CustomerDao;
import com.hibernate.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerDao dao;

    @PostMapping(value = "/{branchIFSC}")
    public long addCustomer(@RequestBody Customer customer, @PathVariable String branchIFSC){
        return dao.createCustomer(customer,branchIFSC);
    }

    @GetMapping(value = "/{accountNumber}")
    public Customer getCustomer(@PathVariable long accountNumber)
    {
        return dao.getCustomerDetails(accountNumber);
    }

    @PutMapping(value = "/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer)
    {
        return dao.updateCustomerDetails(customer,id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteCustomer(@PathVariable int id){
        dao.deleteCustomer(id);
        return "deleted customer with id:"+id+" and associated account";
    }


}
