package com.example.RestControl.Controllers;

import java.util.concurrent.atomic.AtomicLong;


import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;   
import java.time.LocalDateTime;   
import java.time.format.DateTimeFormatter;
import com.example.RestControl.*;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.RestControl.Asks;
import com.example.RestControl.Services.AsksService;


@RestController
public class AsksRestController {

	@Autowired
	AsksService asksService;
	
	
	@GetMapping("/bn/api/asks")
	public List<Asks> getAsks() {
	    return asksService.getAsks();
	}
	
	@PostMapping("/bn/api/accounts/{uid}/asks")
	@ResponseStatus(HttpStatus.CREATED)
	public Asks addAsk(@RequestBody Asks newAsks, @PathVariable("uid") String uid, HttpServletResponse response) {
		response.setHeader("Location", "/bn/api/accounts/" + uid + "/asks");
		return asksService.addAsks(newAsks);
	}
	
	@GetMapping("/bn/api/asks/{aid}")
	public ResponseEntity<Asks> getAsksByAid(@PathVariable("aid")String askId) {
		Asks asks = asksService.getAsksByAid(askId);
		if(asks == null) {
			return new ResponseEntity<Asks> (HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Asks> (asks,HttpStatus.OK);
	}
	@GetMapping("/bn/api/accounts/{uid}/asks/{aid}/deactivate")
	public ResponseEntity<Asks> deactivateAsks(@PathVariable("aid")String askId) {
		Asks asks = asksService.getAsksByAid(askId);
		Asks deactivatedAsk = asksService.deactivateAsks(asks);
		if(asks == null) {
			return new ResponseEntity<Asks> (HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Asks> (deactivatedAsk,HttpStatus.OK);
	}

	
	
	@PutMapping("/bn/api/accounts/{uid}/asks/{aid}")
	public Map putAsks(@RequestBody Asks updatedAsk,  HttpServletResponse response) {

		response.setStatus(204);
		return asksService.updateAsks(updatedAsk);
		
	}
}
