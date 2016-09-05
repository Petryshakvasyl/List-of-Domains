package ua.oril.pv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.oril.pv.entity.Domain;
import ua.oril.pv.service.DomainService;

import java.util.List;

/**
 * Created by pevsat on 02.09.2016.
 */
@Controller
public class LisfOfDomainsComtroller {

    @Autowired
    DomainService domainService;

    @RequestMapping(value = "ListOfDomains")
    public ModelAndView listOfDomains(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list-of-domains");
        List<Domain> listDomain = domainService.findAll();
        model.addAttribute("AllDomains", listDomain);
        return modelAndView;
    }

}
