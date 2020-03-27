package com.hibernate.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="branch")
public class Branch {
    @Id
    @Column(name="branchIFSC")
    private String branchIFSC;
    @Column(name = "name")
    private String name;
    @Column(name = "Type")
    private String Type;
    @Column(name = "Address")
    private String Address;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL},
            mappedBy = "branch")
    private List<Customer> customers;

    public void setBranchIFSC(String branchIFSC) {
        this.branchIFSC = branchIFSC;
    }

    public String getBranchIFSC() {
        return branchIFSC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


    public Branch(String branchIFSC, String name, String type, String address, List<Customer> customers) {
        this.branchIFSC = branchIFSC;
        this.name = name;
        Type = type;
        Address = address;
        this.customers = customers;
    }

    public Branch() {
    }

    public void addCustomers(Customer customer)
    {
        if(customers == null)
        {
            customers = new ArrayList<Customer>();
        }
        customers.add(customer);
        customer.setBranch(this);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchIFSC='" + branchIFSC + '\'' +
                ", name='" + name + '\'' +
                ", Type='" + Type + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
