package com.pact.myapi.restapi.repo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pact.myapi.dto.Address;
import com.pact.myapi.dto.Student;

@Repository
public class StudentRepo {
	
	HashMap<String,Student> mapOfStudents = null;
	
	public StudentRepo() {
		
		if(mapOfStudents==null){
			
			mapOfStudents = new HashMap<String,Student>();
			
			mapOfStudents.put("12", new Student("David", "Bower", new Address("1126CV", "Gigi")));
			mapOfStudents.put("13", new Student("Ted", "Bundy", new Address("1185GT", "Longroute")));
			mapOfStudents.put("14", new Student("Jacob", "Frost", new Address("1126CV", "Gigi")));
			mapOfStudents.put("15", new Student("Mickey", "Mouse", new Address("1026YV", "Arjenstraat")));
			
		}
		 
	}
	
	public List getAll(){
		
		return Arrays.asList(mapOfStudents.values().toArray());
	}
	
	public Student getOne(String id){
		
		return mapOfStudents.get(id);
	}
	
	public Student removeData(String id) {
		return mapOfStudents.remove(id);
	}
	
	public Student addData(String id,Student stu) {
		mapOfStudents.put(id, stu);
		return mapOfStudents.get(id);
	}

}
