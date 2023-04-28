package com.example.cashierapp;

import com.example.cashierapp.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/*
    RestTemplate JavaDoc:
        * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html
    Tutorial Resources:
        * https://reflectoring.io/spring-resttemplate
        * https://www.baeldung.com/rest-template
        * https://springframework.guru/enable-pretty-print-of-json-with-jackson
 */

@Controller
@RequestMapping("/")
public class CashierController {

    @Value("${apiKey}")
    private String apiKey;

    @GetMapping
    public String getAction(@ModelAttribute("command") CashierCommand command,
                            Model model) {
        return "cashier";
    }

    @PostMapping
    public String postAction(@ModelAttribute("command") CashierCommand command,
                             @RequestParam(value = "action", required = true) String action,
                             @RequestParam(value = "drink") String drink, @RequestParam(value = "milk") String milk,
                             @RequestParam(value = "size") String size,
                             Errors errors, Model model, HttpServletRequest request) {

        System.out.println( command );

        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "" ;
        String message = "";


        if (action.equals("PLACE ORDER")) {
            message = "";
            resourceUrl = "http://34.71.205.3:80/api/order/register/5012349";
//            resourceUrl = "http://localhost:8080/order/register/5012349";
            // get response as POJO
            Order orderRequest = new Order() ;
            if (drink == "None" || milk == "None" || size == "None") {
                return null;
            }
            orderRequest.setDrink(drink) ;
            orderRequest.setMilk(milk) ;
            orderRequest.setSize(size);
            HttpHeaders headers = new HttpHeaders();
            headers.add("apikey", apiKey);
            HttpEntity<Order> newOrderRequest = new HttpEntity<Order>(orderRequest, headers) ;
            ResponseEntity<Order> newOrderResponse = restTemplate.postForEntity(resourceUrl, newOrderRequest, Order.class);
            Order newOrder = newOrderResponse.getBody();
            System.out.println( newOrder );
            // pretty print JSON
            try {
                ObjectMapper objectMapper = new ObjectMapper() ;
                String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newOrder);
                System.out.println( jsonString) ;
                message = "\n" + jsonString ;
            }
            catch ( Exception e ) {}
        }

        if (action.equals("CLEAR ORDER")) {
            resourceUrl = "http://34.71.205.3:80/api/order/register/5012349";
//            resourceUrl = "http://localhost:8080/order/register/5012349";
            String status = "status";
            String statusVal = "Ready for Payment.";
            Map< String, String > params = new HashMap< String, String >();
            params.put(status, statusVal);
            message = "Cleared order";
            String emptyRequest = "" ;
            HttpHeaders headers = new HttpHeaders();
            headers.add("apikey", apiKey);
            HttpEntity<?> deleteRequest = new HttpEntity<Object>(headers) ;
            restTemplate.exchange(resourceUrl, HttpMethod.DELETE, deleteRequest, String.class);
            // pretty print JSON
        }


        model.addAttribute("message", message);
        return "cashier";
    }
    

}