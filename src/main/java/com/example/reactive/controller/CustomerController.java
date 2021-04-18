package com.example.reactive.controller;

import com.example.reactive.dto.Customer;
import com.example.reactive.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
        @Autowired
        private CustomerService service;
        @GetMapping
        public List<Customer> getAllCustomers()
    {
    return service.loadAllCustomers();
    }

    @GetMapping(value = "/streams",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomersStream()
    {
        return service.loadCustomersStream();
    }



}
