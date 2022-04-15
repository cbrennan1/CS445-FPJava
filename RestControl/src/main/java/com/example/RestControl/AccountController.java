package com.example.RestControl;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountController {
    private static final String template = "Hello";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/bn/api/accounts")
    public List<accounts> getAccounts () {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        date_created = (dtf.format(now)); 
        accounts a0 = new accounts("<uid0>", "Virgil Bistriceanu", "10 West", "31st ST", 60616, "312-567-5146", "http://cs.iit.edu/~virgil/pictures/virgil-head-small-200811.jpg", true, date_created);
        accounts a1 = new accounts("<uid1", "Jane Smith", "123 ", "2nd ST", 60607, "217-456-7890", "http://example.com/images/jane-smith.jpeg", false, date_created);
        accounts a2 = new accounts("<uid2>", "CSR #1", "101 West", "Main ST", 60010, "(847) 842-8048", "http://example.com/images/jane-smith.jpeg", true, date_created);
        List<accounts> list = new ArrayList<>();
        list.add(a0);
        list.add(a1);
        list.add(a2);
        return list;
    }

    
}