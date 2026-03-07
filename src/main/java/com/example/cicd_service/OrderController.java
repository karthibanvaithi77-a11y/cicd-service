package com.example.cicd_service;

import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @GetMapping("/orders")
    public String getOrders() {
        return "Order Service Running";
    }

}
