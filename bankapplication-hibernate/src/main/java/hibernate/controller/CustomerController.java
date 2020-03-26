package hibernate.controller;

import hibernate.model.Customer;
import hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/customerList", method= RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("customer/customerList");
        List list = customerService.listAllCustomers();
        model.addObject("list", list);
        return model;
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("customer/customerForm");
        Customer customer = customerService.findCustomerById(id);
        model.addObject("customerForm", customer);
        return model;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id){
        customerService.deleteCustomer(id);
        return new ModelAndView("redirect:/customer/customerList");
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView add(){
        ModelAndView model = new ModelAndView("customer/customerForm");
        Customer customer = new Customer();
        model.addObject("customerForm", customer);
        return model;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("customerForm") Customer customer){
        customerService.saveOrUpdate(customer);
        return new ModelAndView("redirect:/customer/customerList");
    }
}
