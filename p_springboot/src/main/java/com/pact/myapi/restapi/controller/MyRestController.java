package com.pact.myapi.restapi.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pact.myapi.dto.Student;
import com.pact.myapi.restapi.repo.StudentRepo;

@RestController
@RequestMapping("/myapi")
public class MyRestController {
	
	@Autowired
	StudentRepo studentRepo;
	
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentData(@PathVariable("id")String idValue){
		
		Student stud = studentRepo.getOne(idValue);
		
		return stud!=null?new ResponseEntity<>(stud,HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/students")
	public List getStudents(){
		
		return studentRepo.getAll();
	}
	
	@PostMapping("/student")
	public Student createStudentData(@RequestBody Student data){
		
		Random rand = new Random();
		
		return studentRepo.addData(rand.nextInt()+"", data);
	}
	
	@PostMapping("/studentquery")
	public Student createStudentDataQuery(@RequestBody Student data,@RequestParam Map<String, String> queryParameters){
		
		Random rand = new Random();
		
		if(queryParameters.get("firstName")!=null)
			data.setFirstName(queryParameters.get("firstName"));
		if(queryParameters.get("lastName")!=null)
		    data.setLastName(queryParameters.get("lastName"));
		
		return studentRepo.addData(rand.nextInt()+"", data);
	}
	
	@PostMapping("/student/{id}")
	public Student createStudentData(@PathVariable("id")String idValue,@RequestBody Student data){
		
		//Random rand = new Random();
		
		return studentRepo.addData(idValue, data);
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student> deleteStudentData(@PathVariable("id")String idValue){
		
		Student stud = studentRepo.removeData(idValue);
		
		return stud!=null?new ResponseEntity<>(stud,HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}

}
