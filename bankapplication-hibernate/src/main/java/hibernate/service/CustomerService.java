package hibernate.service;

import hibernate.dao.CustomerDao;
import hibernate.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List listAllCustomers() {
        return customerDao.listAllCustomers();
    }

    public void saveOrUpdate(Customer customer) {
        customerDao.saveOrUpdate(customer);
    }

    public Customer findCustomerById(int id) {
        return customerDao.findCustomerById(id);
    }

    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }
}
