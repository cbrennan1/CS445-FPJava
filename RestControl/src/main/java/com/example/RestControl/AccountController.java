package com.example.RestControl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.json.simple.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bn/api")
public class AccountController {
	
	
	private final AtomicLong counter = new AtomicLong();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    LocalDateTime date_created = LocalDateTime.now();
    String formatted_date = date_created.format(myFormatObj);
    
	accounts account0 = new accounts("<uid" + counter.getAndIncrement() + ">", "Virgil Bistriceanu", "10 West 31st ST", "60616", "312-567-5146", "http://cs.iit.edu/~virgil/pictures/virgil-head-small-200811.jpg", true, formatted_date);
	accounts account1 = new accounts("<uid" + counter.getAndIncrement() + ">", "Jane Smith", "123 2nd ST", "60607", "217-456-7890", "http://example.com/images/jane-smith.jpeg", false, formatted_date);
	accounts account2 = new accounts("<uid" + counter.getAndIncrement() + ">", "CSR #1",  "101 W Main St.", "60010", "(847) 842-8048", "http://example.com/images/jane-smith.jpeg", true, formatted_date);
    	
    
	@GetMapping(path="/accounts"
	public List<accounts> getAccounts() {
	    List<accounts> list = new ArrayList<>();
	    list.add(account0);
	    list.add(account1);
	    list.add(account2);
	    return list;
	}
}

