package com.pact.myapi.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mytextapi")
public class NewController {
	
	@GetMapping(path="/studenttext",produces="text/plain")
	public @ResponseBody ResponseEntity<String> getStudentData(){
		
		String stud = "Hello How are you doin today? I am good.Thank you";
		
		return stud!=null?new ResponseEntity<>(stud,HttpStatus.OK):new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		
	}

}
