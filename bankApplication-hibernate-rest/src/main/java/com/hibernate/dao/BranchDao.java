package com.hibernate.dao;

import com.hibernate.model.Branch;
import com.hibernate.model.Customer;

import java.util.List;

public interface BranchDao {

    Branch createBranch(Branch branch);

    void deleteBranch(String code);

    List<Customer> getAllCustomers(String branchCode);

}
