package com.hibernate.dao;

import com.hibernate.model.Branch;
import com.hibernate.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BranchDaoimpl  implements  BranchDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public Branch createBranch(Branch branch) {
        Session session = sessionFactory.getCurrentSession();
        session.save(branch);
        return branch;
    }

    @Override
    @Transactional
    public void deleteBranch(String code) {
        Session session = sessionFactory.getCurrentSession();
        Branch branch = session.get(Branch.class,code);
        session.delete(branch);
    }

    @Override
    @Transactional
    public List<Customer> getAllCustomers(String branchIFSC) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from branch ");
        List<Customer> customers = query.list();
        System.out.println(customers);
        return customers;
    }

}
