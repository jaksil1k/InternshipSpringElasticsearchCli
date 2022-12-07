package com.task3.springbootcli.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ElasticSearchService {
    @Value("Vlad")
    private String name;

    public String getHelloMessage(String guest) {
        return "Hello from " + this.name + " to " + guest;
    }
}
