package com.example.RestControl;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private static final String template = "Hello";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/bn/api/accounts")
    public accounts accounts(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new accounts(counter.incrementAndGet(), String.format(template,name), name, name, 0, name, name, false, name);
    }

    
}