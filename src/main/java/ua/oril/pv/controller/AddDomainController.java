package ua.oril.pv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.oril.pv.entity.Domain;
import ua.oril.pv.service.DomainService;

/**
 * Created by pevsat on 02.09.2016.
 */
@Controller
public class AddDomainController {

    @Autowired
    DomainService domainService;

    @RequestMapping(value = "addDomain")
    public ModelAndView addDomains() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-domain");
        return modelAndView;
    }

        @RequestMapping(value = "addDomain", method = RequestMethod.POST)
        public String saveDomain (@ModelAttribute("add-domain") Domain d){
            domainService.create(d);
            System.out.println(d.getName());
        return "savedDomain";
    }
}
