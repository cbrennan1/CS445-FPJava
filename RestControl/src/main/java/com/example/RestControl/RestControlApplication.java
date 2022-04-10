package com.example.RestControl;
// Test

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestControlApplication.class, args);
		SpringApplication.run(accounts.class, args);

	}
	
@GetMapping("/bn/api")
public String hello(@RequestParam(value = "name", defaultValue = "Computers") String name) {
return String.format("Hello %s!", name); }

private static final String template = "Hello";
private final AtomicLong counter = new AtomicLong();

    @GetMapping("/bn/api/accounts")
    public accounts accounts(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new accounts(counter.incrementAndGet(), String.format(template,name), name, name, 0, name, name, false, name);
    }

}
