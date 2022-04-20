package com.example.RestControl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class AccountsService {
	private final AtomicLong counter = new AtomicLong();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    LocalDateTime date_created = LocalDateTime.now();
    String formatted_date = date_created.format(myFormatObj);
    public Map address0 = new LinkedHashMap(2);
	private Map address1 = new LinkedHashMap(2);
	private Map address2 = new LinkedHashMap(2);
	
	Accounts account0 = new Accounts("<uid" + counter.getAndIncrement() + ">", "Virgil Bistriceanu", address0, "312-567-5146", "http://cs.iit.edu/~virgil/pictures/virgil-head-small-200811.jpg", true, formatted_date);
	Accounts account1 = new Accounts("<uid" + counter.getAndIncrement() + ">", "Jane Smith", address1, "217-456-7890", "http://example.com/images/jane-smith.jpeg", false, formatted_date);
	Accounts account2 = new Accounts("<uid" + counter.getAndIncrement() + ">", "CSR #1",  address2, "(847) 842-8048", "http://example.com/images/jane-smith.jpeg", true, formatted_date);

	

	public List<Accounts> getAccounts() {
		
		this.address0.put("street", "10 West 31st ST");
		this.address0.put("zip", "60616");
		this.address1.put("street", "123 2nd ST");
		this.address1.put("zip", "60607");
		this.address2.put("street", "101 W Main St.");
		this.address2.put("zip", "60010");
		
		
	    List<Accounts> list = new ArrayList<>();
	    list.add(account0);
	    list.add(account1);
	    list.add(account2);
	    return list;
	}
	
	public Accounts getAccountsbyUID(String uid) {
		
		Predicate<Accounts> byUid = p -> p.getUid().equals(uid);
		return filterAccounts(byUid);
	}
	
	private Accounts filterAccounts(Predicate<Accounts> strategy) {
		return getAccounts().stream().filter(strategy).findFirst().orElse(null);
	}

	public Accounts addAccount(Accounts newAccount) {
		Accounts account3 = new Accounts("<uid" + counter.getAndIncrement() + ">", newAccount.getName(),  newAccount.getAddress(), newAccount.getPhone(), newAccount.getPicture(), newAccount.getIs_active(), newAccount.getDate_Created());
		return account3;
	}
	
	public Accounts putAccount(Accounts newAccount) {
		Accounts account3 = new Accounts(newAccount.getUid(), newAccount.getName(),  newAccount.getAddress(), newAccount.getPhone(), newAccount.getPicture(), newAccount.getIs_active(), newAccount.getDate_Created());
		return account3;
	}
	/*
	public Accounts testFour(String uid) {
		Object account3 = putAccount(account0);
		return account3;
		}
	*/
}
