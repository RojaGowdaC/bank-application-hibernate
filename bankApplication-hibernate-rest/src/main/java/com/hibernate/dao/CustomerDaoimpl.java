package com.hibernate.dao;

import com.hibernate.model.Account;
import com.hibernate.model.Branch;
import com.hibernate.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Random;

@Repository
public class CustomerDaoimpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public long createCustomer(Customer customer, String branchCode) {
        Session session = sessionFactory.getCurrentSession();
        Branch branch = session.get(Branch.class,branchCode);
        Random random = new Random();
        long accNo = Long.parseLong(branchCode.substring(0,4)+(random.nextInt(9000)+1000));
        Account account = new Account(accNo,0);
        account.setCustomer(customer);
        branch.addCustomers(customer);
        session.save(account);
        return accNo;
    }

    @Override
    @Transactional
    public Customer getCustomerDetails(long accNo) {
        Session session =sessionFactory.getCurrentSession();
        Account account = session.get(Account.class,accNo);
        Customer customer = account.getCustomer();
        return new Customer(customer.getId(), customer.getName(), customer.getContactNo(),customer.getBranch(), customer.getAccount());
    }

    @Override
    @Transactional
    public Customer updateCustomerDetails(Customer customer, int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Customer set name= :name , contactNo= :contactNo, branch= :branch," +"Account= :Account where id= :id");
        query.setParameter("id",customer.getId());
        query.setParameter("name",customer.getName());
        query.setParameter("contactNo",customer.getContactNo());
       query.setParameter("branch",customer.getBranch());
        query.setParameter("Acccount", customer.getAccount());
        query.executeUpdate();
        Customer customer1 = session.get(Customer.class,id);
        return new Customer(customer.getId(), customer.getName(), customer.getContactNo(), customer.getBranch(),customer.getAccount());
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,id);
        session.delete(customer);
    }
}
