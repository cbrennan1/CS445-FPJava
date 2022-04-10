package com.example.RestControl;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GivesController {
	private static final String template = "Hello";
	private final AtomicLong counter = new AtomicLong();
	private final AtomicLong aCounter = new AtomicLong();
	private final int[] zipArray = new int[2];
	
	@GetMapping("/bn/api/gives")
	public Gives gives(@RequestParam(value = "type", defaultValue = "Customer Service") String type) {
		return new Gives(counter.incrementAndGet(), aCounter.incrementAndGet(), type, type, type, type, zipArray, true, type);
	}
}
