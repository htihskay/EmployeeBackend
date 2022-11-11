package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface Erepository extends CrudRepository<Employee, Integer>{//type of object or table, type of primarykey
//	
//}
public interface Erepository extends JpaRepository<Employee, Integer>{//type of object or table, type of primarykey
	
	//@Query("select u from Employee u where u.etype='IT' ")
	//nativeQuery ->actualy sql queries->executed ate database Client
	@Query(value="select * from Employee3 where etype='IT' ",nativeQuery=true)
	List<Employee> getItEmployee();
	
	
	List<Employee> findbyIdAndEtype(Integer id,String etype);
	
}