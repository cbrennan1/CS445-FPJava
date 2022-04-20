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
	
	@Autowired
	AccountsService accountsService;
	
	
	@GetMapping("/accounts")
	public List<Accounts> getAccounts(){
		return accountsService.getAccounts();
		
	}
	
	@GetMapping("/accounts/{uid}")
	public ResponseEntity<Accounts> getAccountsbyUid(@PathVariable("uid") String accountUid) {
		
		Accounts account = accountsService.getAccountsbyUid(accountUid);
		if(account == null) {
			return new ResponseEntity<Accounts> (account,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Accounts> (account,HttpStatus.OK);
	}
	
	@PostMapping("/accounts")
	@ResponseStatus(HttpStatus.CREATED)
	public Accounts addAccount(@RequestBody Accounts newAccount, HttpServletResponse response) {
		response.setHeader("Location", "/bn/api/accounts/" + newAccount.getUid());
		return accountsService.addAccount(newAccount);
	}
	
	@PutMapping("/accounts/{uid3}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Accounts putAccounts(@RequestBody Accounts updatedAccount,  HttpServletResponse response) {
	    return accountsService.putAccount(updatedAccount);
	}
	
	/*
	@GetMapping("/accounts/<uid3>")
	public ResponseEntity<Accounts> testFour(String accountUid) {
			
			Accounts account = accountsService.getAccountsbyUID(accountUid);
			if(account == null) {
				return new ResponseEntity<Accounts> (account,HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Accounts> (account,HttpStatus.OK);
		}
	*/
}

