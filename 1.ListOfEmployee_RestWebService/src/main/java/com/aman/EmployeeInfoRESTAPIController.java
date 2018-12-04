package com.aman;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeInfoRESTAPIController {
	@RequestMapping(value ="/employeesList" , method = RequestMethod.GET, produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Emp> getEmployeeList(){
		Emp emp1 = new Emp();
		emp1.setName("Aman");

		Emp emp2 = new Emp();
		emp2.setName("Jashan");

		Emp emp3 = new Emp();
		emp3.setName("Rahul");

		ArrayList<Emp> employeeList= new ArrayList<Emp>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);

		return employeeList;
	}

	@RequestMapping(value ="/employeesList/{name}" , method = RequestMethod.GET , 
			produces={org.springframework.http.MediaType.APPLICATION_JSON_VALUE,org.springframework.http.MediaType.APPLICATION_XML_VALUE})
	public Emp getEmployee(@PathVariable("name") String employeeName){
		//fetch the employee's record using employeeName from DB.
		//Writing below code to proof this concept as of now.
		Emp emp = new Emp();
		emp.setName(employeeName);
		emp.setId(5);
		return emp;
	}
	
	
	@RequestMapping(value ="/employee/{name}" , method = RequestMethod.PUT, consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateEmployee(@PathVariable("name") String employeeName, @RequestBody Emp emp){
		
		System.out.println("Employee Name : " + employeeName);
		System.out.println("Employee Name : "+ emp.getName() + " Employee ID:" + emp.getId());
		
		//find the matching employee's record using employeeName from DB.
		//update the matching employee's record with the information of employee sent be the client.
		
		//return true if update is successfully done and return false if update is failed.
		
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Key1", "value1");
		httpHeaders.add("Key1", "value1");// we can add as many as key value pairs.
		
		return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.OK);
	}
	

	@RequestMapping(value ="/employeesPost" , method = RequestMethod.POST, consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> postEmployee(@RequestBody Emp emp){

		System.out.println("Employee Name : "+ emp.getName() + " Employee ID:" + emp.getId());
		//insert the record into DB

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location",
					ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{name}")
					.buildAndExpand(emp.getName()).toUri()
					.toString());
		
				
		return new ResponseEntity<Boolean>(true,httpHeaders, HttpStatus.CREATED); // we should not send OK status code for POST method., 
																	  //its just about to CREATED status code as developer
	}
	
	@RequestMapping(value ="/deleteEmployee/{name}" , method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("name") String employeeName){

		System.out.println("Employee Name :"+employeeName);
		//delete the employee record from DB

		return new ResponseEntity<Boolean>(true, HttpStatus.OK);  
	}
	
	@RequestMapping(value ="/deleteAllEmployee" , method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAllEmployee(){

		//delete the all the employee records from DB

		return new ResponseEntity<Boolean>(true, HttpStatus.OK);  
	}
}
