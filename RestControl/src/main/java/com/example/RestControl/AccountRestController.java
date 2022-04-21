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
public class AccountRestController {
		
	
	@Autowired
	AccountsService accountsService;
    
	@GetMapping("/bn/api/accounts")
	public List<Accounts> getAccounts() {
	    return accountsService.getAccounts();
	}
	
	@GetMapping("/bn/api/accounts/{uid}")
	public ResponseEntity<Accounts> getAccountsByUid(@PathVariable("uid")String accountId) {
		Accounts account = accountsService.getAccountsbyUid(accountId);
		if(account == null) {
			return new ResponseEntity<Accounts> (HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Accounts> (account,HttpStatus.OK);
	}
	
	@GetMapping("/bn/api/accounts/{uid}/activate")
	public ResponseEntity<Accounts> activateUpdatedAccount(@PathVariable("uid")String accountId) {
		Accounts account = accountsService.getAccountsbyUid(accountId);
		if(account == null) {
			return new ResponseEntity<Accounts> (HttpStatus.NOT_FOUND);
		}
		Accounts activatedAccount = accountsService.activateUpdatedAccount(account);
		return new ResponseEntity<Accounts> (activatedAccount,HttpStatus.OK);
	}
	
	@GetMapping("/bn/api/accounts?key=main")
	public ResponseEntity<List<Accounts>> mainKey(String accountId1, String accountId2, HttpServletResponse response) {
		accountId1 = "<uid2>";
		accountId2 = "<uid3>";
		Accounts account1 = accountsService.getAccountsbyUid(accountId1);
		Accounts account2 = accountsService.getAccountsbyUid(accountId2);
		List<Accounts> list = new ArrayList<>();
	    list.add(account1);
	    list.add(account2);
		response.setStatus(200);
		return new ResponseEntity<List<Accounts>> (list,HttpStatus.OK);
	}

	
	@PostMapping("/bn/api/accounts")
	@ResponseStatus(HttpStatus.CREATED)
	public Accounts addAccount(@RequestBody Accounts newAccount, HttpServletResponse response) {
		response.setHeader("Location", "/bn/api/accounts/" + newAccount.getUid());
		return accountsService.addAccount(newAccount);
	}
	

	@PutMapping("/bn/api/accounts/{uid3}")
	public Map putAccounts(@RequestBody Accounts updatedAccount,  HttpServletResponse response) {
	    Map account= accountsService.updateAccounts(updatedAccount);
		if(account == null) {
			response.setStatus(204);
			return null;
		} else {
		response.setStatus(400);
		return account; }
	}

	/*
	public Accounts putAccounts(@PathVariable(value="uid")String uid, @RequestBody Accounts updatedAccount,  HttpServletResponse response) {
	    return accountsService.updateAccounts(updatedAccount);
	}
	*/
}
