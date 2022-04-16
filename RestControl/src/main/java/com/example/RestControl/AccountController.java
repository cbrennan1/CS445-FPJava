package com.example.RestControl;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;   
import java.time.LocalDateTime;   
import java.time.format.DateTimeFormatter; 


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountController {
    private static final String template = "Hello";
    private final AtomicLong counter = new AtomicLong(0);

    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    LocalDateTime date_created = LocalDateTime.now();
    String formatted_date = date_created.format(myFormatObj);
        //Object[] addressArray = new ArrayList<>();
        //addressArray[0] = (new String("10 West 31st ST"), new Integer(60616));
        //addressArray[1] = (new String("123 2nd ST"), new Integer(60607));
        //addressArray[2] = (new String("01 West Main St."), new Integer(60010));
    accounts a0 = new accounts("<uid" + counter.getAndIncrement() + ">", "Virgil Bistriceanu", "10",  "West 31st ST", 60616, "312-567-5146", "http://cs.iit.edu/~virgil/pictures/virgil-head-small-200811.jpg", true, formatted_date);
    accounts a1 = new accounts("<uid" + counter.getAndIncrement() + ">", "Jane Smith", "123",  "2nd ST", 60607, "217-456-7890", "http://example.com/images/jane-smith.jpeg", false, formatted_date);
    accounts a2 = new accounts("<uid" + counter.getAndIncrement() + ">", "CSR #1",  "01",  "West Main St.", 60616, "(847) 842-8048", "http://example.com/images/jane-smith.jpeg", true, formatted_date);
       
        @RequestMapping(value = "/bn/api/accounts", method = RequestMethod.GET)
        public List<accounts> getAccounts() {
            List<accounts> list = new ArrayList<>();
            list.add(a0);
            list.add(a1);
            list.add(a2);
            return list;
    }

    
}