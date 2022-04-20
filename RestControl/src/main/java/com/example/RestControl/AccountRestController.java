package com.example.RestControl;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bn/api")
public class AccountRestController {
	
	/*
	private final AtomicLong counter = new AtomicLong();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    LocalDateTime date_created = LocalDateTime.now();
    String formatted_date = date_created.format(myFormatObj); 
    
	Accounts account0 = new Accounts("<uid" + counter.getAndIncrement() + ">", "Virgil Bistriceanu", "10 West 31st ST", "60616", "312-567-5146", "http://cs.iit.edu/~virgil/pictures/virgil-head-small-200811.jpg", true, formatted_date);
	Accounts account1 = new Accounts("<uid" + counter.getAndIncrement() + ">", "Jane Smith", "123 2nd ST", "60607", "217-456-7890", "http://example.com/images/jane-smith.jpeg", false, formatted_date);
	Accounts account2 = new Accounts("<uid" + counter.getAndIncrement() + ">", "CSR #1",  "101 W Main St.", "60010", "(847) 842-8048", "http://example.com/images/jane-smith.jpeg", true, formatted_date);
    	
    
	@GetMapping(path="/Accounts")
	public List<Accounts> getAccounts() {
	    List<Accounts> list = new ArrayList<>();
	    list.add(account0);
	    list.add(account1);
	    list.add(account2);
	    return list;
	}
	@PostMapping(path="/Accounts")
	public List<Accounts> postAccounts() {
	    List<Accounts> list = new ArrayList<>();
	    list.add(account0);
	    list.add(account1);
	    list.add(account2);
	    return list;
	}
	@PutMapping(path="/Accounts")
	public List<Accounts> putAccounts() {
	    List<Accounts> list = new ArrayList<>();
	    list.add(account0);
	    list.add(account1);
	    list.add(account2);
	    return list;
	} 
	*/
	@Autowired
	AccountsService accountsService;
	HttpServletResponse response;
	
	@GetMapping("/accounts")
	public List<Accounts> getAccounts(){
		return accountsService.getAccounts();
		
	}
	
	@GetMapping("/accounts/{uid}")
	public ResponseEntity<Accounts> getAccountsbyUid(@PathVariable("uid") String accountUid) {
		
		Accounts account = accountsService.getAccountsbyUID(accountUid);
		if(account == null) {
			return new ResponseEntity<Accounts> (account,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Accounts> (account,HttpStatus.OK);
	}
	
	@PostMapping("/accounts")
	@ResponseStatus(HttpStatus.CREATED)
	public Accounts addAccount(@RequestBody Accounts newAccount) {
        response.setHeader("Location", "/bn/api/accounts/" + newAccount.getUid());
		return accountsService.addAccount(newAccount);
	}
	
	
}

