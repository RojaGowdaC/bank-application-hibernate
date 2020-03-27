package com.hibernate.model;
import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {
    @Id
    @Column(name="AccountNumber")
    private long accountNumber;

    @Column(name = "Type")
    private String type;

    @Column(name ="balance")
    private double balance;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }





    public Account() {
    }

    public Account(long accountNo, double balance) {
        this.accountNumber = accountNo;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}