package com.example.RestControl.Controllers;

import java.util.concurrent.atomic.AtomicLong;
import com.example.RestControl.*;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportsRestController {
	private static final String template = "Hello";
	private final AtomicLong counter = new AtomicLong();
	private final AtomicLong aCounter = new AtomicLong();
	private final int[] array = new int[2];
	private final String[] allReports = new String[2];
	
	@GetMapping("/bn/api/reports")
	public Reports reports() {
		return new Reports(allReports);
	}
}
