package hibernate.service;

import hibernate.dao.AccountDao;
import hibernate.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountService {

    AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List listAllAccounts() {
        return accountDao.listAllAccounts();
    }

    public void saveOrUpdate(Account account) {
        accountDao.saveOrUpdate(account);
    }

    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }


    public void deleteAccount(int id) {
        accountDao.deleteAccount(id);
    }

}
