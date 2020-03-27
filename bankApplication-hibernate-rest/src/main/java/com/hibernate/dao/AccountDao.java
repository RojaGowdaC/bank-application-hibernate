package com.hibernate.dao;

import com.hibernate.model.Account;

public interface AccountDao {

    String creditAccount(long accNo, double amount);

    String  debitAccount(long accNo, double amount);

    Account getAccountDetails(int customerId);

    void deleteAccount(long accNo);
}
