package ua.oril.pv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pevsat on 06.09.2016.
 */
@Controller
public class ContactInfoController {
    @RequestMapping(value = "/contactInfo")
    public String contactInfo() {
        return "contact-info";
    }
}
