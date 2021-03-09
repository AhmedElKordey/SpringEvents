package com.se2.demo.akka.services;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {
	public String greet(String name) {
        return "Hello, " + name;
    }
}
