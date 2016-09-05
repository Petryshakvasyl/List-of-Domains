package ua.oril.pv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.oril.pv.entity.Domain;
import ua.oril.pv.entity.DomainStatus;
import ua.oril.pv.service.DomainService;

import java.io.IOException;
import java.util.List;

/**
 * Created by pevsat on 05.09.2016.
 */
@Controller
public class UpdateDomainController {

    @Autowired
    DomainService domainService;

    @RequestMapping(value = "/updateDomain")
        public String updateView (Model model){
        List<Domain> listDomain = domainService.findAll();
        model.addAttribute("AllDomains", listDomain);
        return "update-domain";
    }
    @RequestMapping(value = "updateDomainName/{name}/{id}", method = RequestMethod.GET)
    public String updateDomain (@PathVariable String name, @PathVariable Long id) throws IOException {
        Domain domain = domainService.findById(id);
        domain.setName(name);
        domain.setDomainStatus(domainService.isDomainSafe(domain)? DomainStatus.SAFE : DomainStatus.DANGEROUS);
        domainService.update(domain);
        return "update-domain";
    }
    @RequestMapping(value = "/deleteDomain/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteDomain (@PathVariable Long id){
        Domain domain = domainService.findById(id);
        domainService.delete(domain);
    }

    @RequestMapping(value = "/getNameDomain/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getNameDomain (@PathVariable Long id){
        Domain domain = domainService.findById(id);
        String name = domain.getName();
        return name;
    }
}
