package hibernate.controller;

import hibernate.model.Branch;
import hibernate.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping(value="/branch")
public class BranchController {
    @Autowired
    BranchService branchService;

    @RequestMapping(value="/branchList", method= RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("branch/branchList");
        List list = branchService.listAllBranches();
        model.addObject("list", list);
        return model;
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("branch/branchForm");
        Branch branch = branchService.findBranchById(id);
        model.addObject("branchForm", branch);
        return model;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id){
        branchService.deleteBranch(id);
        return new ModelAndView("redirect:/branch/branchList");
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView add(){
        ModelAndView model = new ModelAndView("branch/branchForm");
        Branch branch = new Branch();
        model.addObject("branchForm", branch);
        return model;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("branchForm") Branch branch){
        branchService.saveOrUpdate(branch);
        return new ModelAndView("redirect:/branch/branchList");
    }
}
