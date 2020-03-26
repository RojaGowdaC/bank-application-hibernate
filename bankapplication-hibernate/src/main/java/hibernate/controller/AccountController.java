package hibernate.controller;

import hibernate.model.Account;
import hibernate.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping(value="/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value="/accountList", method= RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("account/accountList");
        List list = accountService.listAllAccounts();
        model.addObject("list", list);
        return model;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id){
        accountService.deleteAccount(id);
        return new ModelAndView("redirect:/account/accountList");
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("accountForm") Account account){
        accountService.saveOrUpdate(account);
        return new ModelAndView("redirect:/account/accountList");
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("account/accountForm");
        Account account = accountService.findAccountById(id);
        model.addObject("accountForm", account);
        return model;
    }


}
