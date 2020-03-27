package com.hibernate.controller;


import com.hibernate.dao.BranchDao;
import com.hibernate.model.Branch;
import com.hibernate.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    BranchDao dao;

    @PostMapping("/")
    public Branch addBranch(@RequestBody Branch branch)
    {
        return dao.createBranch(branch) ;
    }

    @GetMapping(value = "/{branchIFSC}")
    public List<Customer> getAllCustomers(@PathVariable String branchIFSC)
    {
        return dao.getAllCustomers(branchIFSC);
    }

    @DeleteMapping(value = "/{branchIFSC}")
    public void deleteBranch(@PathVariable String branchIFSC){
        dao.deleteBranch(branchIFSC);
    }

}
