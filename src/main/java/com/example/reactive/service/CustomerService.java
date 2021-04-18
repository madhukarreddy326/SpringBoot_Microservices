package com.example.reactive.service;

import com.example.reactive.dao.CustomerDao;
import com.example.reactive.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao dao;

    public List<Customer> loadAllCustomers()
    {
    long start = System.currentTimeMillis();
    List<Customer> customers = dao.getCustomers();
    long end = System.currentTimeMillis();

    System.out.println("Total Execution Time: "+(end-start));
    return customers;
    }

    public Flux<Customer> loadCustomersStream()
    {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = dao.getCustomersStream();
        long end = System.currentTimeMillis();

        System.out.println("Total Execution Time: "+(end-start));
        return customers;
    }
}
