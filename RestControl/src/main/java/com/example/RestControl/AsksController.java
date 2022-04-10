package com.example.RestControl;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsksController {
	private static final String template = "Hello";
	private final AtomicLong counter = new AtomicLong();
	private final AtomicLong aCounter = new AtomicLong();
	private final int[] array = new int[2];
	
	@GetMapping("/bn/api/asks")
	public Asks asks(@RequestParam(value = "type", defaultValue = "Customer Service") String type) {
		return new Asks(counter.incrementAndGet(), aCounter.incrementAndGet(), type, type, type, type, array, true, type);
	}
}
