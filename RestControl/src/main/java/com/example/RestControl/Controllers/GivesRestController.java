package com.example.RestControl.Controllers;


import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;


import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import com.example.RestControl.Gives;
import com.example.RestControl.Services.GivesService;


@RestController
public class GivesRestController {

	@Autowired
	GivesService givesService;
	
	@PostMapping("/bn/api/accounts/{uid}/gives")
	@ResponseStatus(HttpStatus.CREATED)
	public Gives addGives(@RequestBody Gives newGive, @PathVariable("uid") String uid, HttpServletResponse response) {
		response.setHeader("Location", "/accounts/%3Cuid3%3E/gives/<gid1>");
		return givesService.addGives(newGive);
	}
	@PutMapping("/bn/api/accounts/{uid}/gives/{gid}")
	public Map putGives(@RequestBody Gives updatedGive,  HttpServletResponse response) {

		response.setStatus(204);
		return givesService.updateGives(updatedGive);
	}

}

