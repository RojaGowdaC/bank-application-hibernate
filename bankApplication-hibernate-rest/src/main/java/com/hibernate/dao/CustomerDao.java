package com.hibernate.dao;


import com.hibernate.model.Customer;


public interface CustomerDao {

    long createCustomer(Customer customer, String branchCode);

    Customer getCustomerDetails(long accNo);

    Customer updateCustomerDetails(Customer customer, int id);

    void deleteCustomer(int id);


}
