package com.example.cashierapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
    @RequestMapping(value = "/drinks", method = RequestMethod.GET)
    public String drinks() {
        return "drinks";
    }

    @RequestMapping(value = "/drinks/caffelatte", method = RequestMethod.GET)
    public String caffelatte() {
        return "caffelatte" ;
    }

    @RequestMapping(value = "/drinks/caffeamericano", method = RequestMethod.GET)
    public String caffeamericano() {
        return "caffeamericano" ;
    }

    @RequestMapping(value = "/drinks/caffemocha", method = RequestMethod.GET)
    public String caffemocha() {
        return "caffemocha" ;
    }

    @RequestMapping(value = "/drinks/cappuccino", method = RequestMethod.GET)
    public String cappuccino() {
        return "cappuccino" ;
    }

    @RequestMapping(value = "/drinks/espresso", method = RequestMethod.GET)
    public String espresso() {
        return "espresso" ;
    }

}