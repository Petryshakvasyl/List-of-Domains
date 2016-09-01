package ua.oril.pv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pevsat on 01.09.2016.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
