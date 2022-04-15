package com.example.RestControl;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountController {
    private static final String template = "Hello";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/bn/api/accounts")
    public accounts getAccounts () {
        accounts accounts = new accounts("<uid0>", "Virgil Bistriceanu", "10 West", "31st ST", 60616, "312-567-5146", "http://cs.iit.edu/~virgil/pictures/virgil-head-small-200811.jpg", true, "<date0>");
        accounts accounts = new accounts("<uid1>", "Virgil Bistriceanu", "10 West", "31st ST", 60616, "312-567-5146", "http://cs.iit.edu/~virgil/pictures/virgil-head-small-200811.jpg", true, "<date0>");
        accounts accounts = new accounts("<uid2>", "Virgil Bistriceanu", "10 West", "31st ST", 60616, "312-567-5146", "http://cs.iit.edu/~virgil/pictures/virgil-head-small-200811.jpg", true, "<date0>");
        return accounts;
    }

    
}