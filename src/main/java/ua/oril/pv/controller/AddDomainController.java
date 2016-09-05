package ua.oril.pv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.oril.pv.entity.Domain;
import ua.oril.pv.entity.DomainStatus;
import ua.oril.pv.service.DomainService;

import javax.naming.ServiceUnavailableException;
import java.io.IOException;

/**
 * Created by pevsat on 02.09.2016.
 */
@Controller
public class AddDomainController {

    @Autowired
    DomainService domainService;

    @RequestMapping(value = "/")
    public ModelAndView addDomains() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

        @RequestMapping(value = "/addDomain", method = RequestMethod.POST)
        public ModelAndView saveDomain (Model model, @ModelAttribute("add-domain") Domain domain) throws IOException, ServiceUnavailableException {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("savedDomain");
            domain.setDomainStatus(domainService.isDomainSafe(domain)?DomainStatus.SAFE : DomainStatus.DANGEROUS);
            model.addAttribute("newDomain", domain);
            domainService.create(domain);
        return modelAndView;
    }
}
