package com.example.demo;
import com.example.handler.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.InvalidAttributeValueException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



//this annotation register this class as Service classs
//and enables the autowiring the project
@Service
public class Eservice {
//	List<Employee> elist=new ArrayList<Employee>();
//	public Eservice() {
//		System.out.println("Service Layer created");
//		
//		elist.add(new Employee(1,"Yakshith"));
//		elist.add(new Employee(2,"Vishni"));
//		elist.add(new Employee(3,"Vishnu"));
//	}
	
	private static Logger LOGGER = LoggerFactory.getLogger(Eservice.class);
	
	@Autowired
	private Erepository emprepo;
	
	@Autowired
	private Addressrepository addrepo;
	
	public List<Employee> addListEmployee(List<Employee> emplistt){
		
		return emprepo.saveAll(emplistt);
	}
	
	//return all the employee list
	public List<Employee> getAllEmployee(){
//		emprepo.save(new Employee(3,"Rakshith"));
//		emprepo.save(new Employee(4,"Akshith"));
		List<Employee> elist=new ArrayList<Employee>();
		emprepo.findAll().forEach(elist ::add);
		
		//System.out.println("**********************************************"+elist);
		LOGGER.info("******************************"+elist);
		System.out.println(emprepo.findAll());
		return elist;
	}
	
	
	@Value("${my.defaultId:5}")
	private int defaultId;
	//why this if i can do using private int defaultId=5;
	
	public Employee getEmployee(int id) throws CustomException{
//		for(Employee e:elist) {
//			if(e.getId()==id) {
//				return e;
//			}
//		}
		if(id<0) {
			//throw new  CustomException();
			//instead of throwing error here I assigned dedault user id;
			id=defaultId;
		}
		Optional<Employee> empbyId=emprepo.findById(id);
		if(empbyId.isPresent()) {
			return empbyId.get();
		}
		
		
		return null;
	}
	
	//adding new employee
	public void addEmployee(Employee addEmp) {
		//this.elist.add(addEmp);
		
		emprepo.save(addEmp);
	}
	
	//updating player
	
	public void updateEmployee(int id,String name) {
		List<Employee> elist=getAllEmployee();
		for(Employee e:elist) {
			if(e.getId()==id) {
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%Condition passed");
				//e.setName("NewBhai");
//				e.setName(name);
//				emprepo.save(new Employee(id,e.getName()));
			}
		}
	
	}
	
	
	
	//delete the employee
	public void deleteEmployee(int id) {
		emprepo.deleteById(id);
	}
	
	public List<Employee> getAllItEmployee() {
		return emprepo.getItEmployee();
	}
	
	public List<Employee> getEmpById(int id,String etype){
		return emprepo.findbyIdAndEtype(id,etype);
	}
}
