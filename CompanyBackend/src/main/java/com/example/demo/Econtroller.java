package com.example.demo;

import java.util.ArrayList;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.handler.*;
//inside bean factory this class will be mapped
@RestController

//@Controller
public class Econtroller {

	private static Logger LOGGER = LoggerFactory.getLogger(Econtroller.class);
	
	//Eservice ob=new Eservice();
	//alternative method --> autowiring
	@Autowired
	private Eservice service;
	
//		defaultString: Yoyoyo
//	  defaultInt: 19999
//	  defaultBool: false
//	  defaultStringArray: one,two,three
//	  defaultIntArray: 1,2,3,4
//	  defaultDouble: 9.99
	//@Value("Defaultvalue")
	
	@Value("${my.defaultString:another default}")
	private String valueString;
	
	@Value("${my.defaultInt}")
	private int valueInt;
	
	@Value("${my.defaultDouble}")
	private String valueDouble;
	
	@Value("${my.defaultBool}")
	private String valueBool;
	
	@Value("${my.defaultStringArray}")
	private String[] valueStringArray;
	
	
	@Value("${my.defaultIntArray}")
	private int[] valueIntArray;
	
	@RequestMapping(value="/defaultvalues")
//	//wrapping data into response body (like json or xml)
//	@ResponseBody
	public String getMessage() {
		return "Hello boss="+valueInt+" || "+valueDouble+" || "+valueBool+" || "+valueString+" || "
				+valueIntArray+" || "+valueStringArray;
		
		
		//return valueStringArray;
	}
	
	
	
	
	@PostMapping("/addlist")
	public List<Employee> addListOfEmployee(@RequestBody List<Employee> employeelist){
		//here json type of data from the postamn converted into java objects
		
		return service.addListEmployee(employeelist);
	}
	
	
	
	//@RequestMapping(value="/emplist",method = RequestMethod.GET)
	//alternative
	@GetMapping(value="/emplist",produces = MediaType.APPLICATION_JSON_VALUE )
	//getting response in xml formate
	//@GetMapping(value="/emplist",produces = MediaType.APPLICATION_ATOM_XML_VALUE)
	public List<Employee> getEmployee() {
		//System.out.println("Hey your are getting employeelist");
		LOGGER.info("Hey your getting employeelist\n");
		System.out.println(service.getAllEmployee());
		return service.getAllEmployee();
		
		
		
	}
	//@RequestMapping(value="/getEmp/{id}",method = RequestMethod.GET)
	@GetMapping(value="/getEmp/{id}")
	public Employee getEmployeeDetails(@PathVariable int id) throws CustomException{
		
		
		return service.getEmployee(id);
	}
	
	@RequestMapping(value="/addEmp",method = RequestMethod.POST)
	//@PostMapping(value="/addEmp")
	public void addEmployeeControll() {
		// service.addEmployee(new Employee(11,"Rubic"));
	}
	
	//@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	@DeleteMapping(value="/delete/{id}")
	public void deleteEomplyeeControl(@PathVariable int id) {
		service.deleteEmployee(id);
	}
	
	
	//updating employee details
	@PutMapping(value="/update/{id}/{name}")
	public void updateEmployeeControl(@PathVariable int id,@PathVariable String name) {
		service.updateEmployee(id,name);
	}
	
	@PutMapping(value="/parameterupdate")
	//link --> localhost:8080/parameterupdate?id=1&name="Lenovo"
	//required=false --> without this parameter api request/response can be made
	public void updateEmployeeControlPrarameter(@RequestParam int id, @RequestParam(defaultValue = "Not assigned") String name) {
		service.updateEmployee(id, name);
	}
	
	
	//Request body
	//example --> json formate data will be bind into the some objects
	
	//request body converts the outworld data formate(json/xml) to the application understandable
	//data formate //here json converted into employee objects
	@PostMapping("/binding")
	public String bindingEmployee(@RequestBody Employee[] emp) {
		LOGGER.info("Total length of object="+emp.length);
		//System.out.println("*************"+emp[0].toString());
		LOGGER.info("*************"+emp[0].toString());
		return "Binded Successfully";
	}
	
	//response body->does exact opposite job of request body
	//converting java objects into client required formate
	
	
	
	@PostMapping("/response")
	public String usingHttpServletResponse(HttpServletResponse response) {
	    response.addHeader("Baeldung-Example-Header", "Value-HttpServletResponse");
	    response.addHeader("authentication", "strongpassword");
	    return "Response with header using HttpServletResponse";
	}
	
	@GetMapping("/greeting")
	public ResponseEntity<String> greeting(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language) {
	    // code that uses the language variable
	    return new ResponseEntity<String>("Status ok", HttpStatus.OK);
	}
	
	
	//here request header
	//binds the hader values into the method parameters
	@GetMapping(value = "/agent")
    @ResponseStatus(value = HttpStatus.OK)
    public void client(@RequestHeader(value="User-Agent") String userAgent) {

		LOGGER.info("User agent is: {}", userAgent);
    }
	@GetMapping(value = "/all")
    @ResponseStatus(value = HttpStatus.OK)
    public void all(@RequestHeader Map<String, String> headers) {

		LOGGER.info("All headers: {}", headers);
    }
	
	//getting all the employee-work in IT;
	@GetMapping(value="/getit",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllIt() {
		return service.getAllItEmployee();
	}
	
	//named Query example. get emp by ID;
	@GetMapping(value="/getbyidandetype/{valueInt}/{etype}",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getByIdControll(@PathVariable int valueInt,@PathVariable String etype){
		
		LOGGER.info("*************************************"+etype);
		return service.getEmpById(valueInt,etype.toString().toUpperCase());
	}
}
