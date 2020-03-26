package hibernate.dao;

import hibernate.model.Account;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }


    public List listAllAccounts() {
        Criteria criteria = getSession().createCriteria(Account.class);
        return (List) criteria.list();
    }


    public void saveOrUpdate(Account account) {
        getSession().saveOrUpdate(account);
    }


    public Account findAccountById(int id) {
        Account account = (Account) getSession().get(Account.class, id);
        return account;
    }

    public void deleteAccount(int id) {
        Account account= (Account) getSession().get(Account.class, id);
        getSession().delete(account);
    }
}
