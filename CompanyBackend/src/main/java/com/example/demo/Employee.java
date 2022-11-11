package com.example.demo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.hibernate.annotations.Entity;

//this is a pojo class represents the table of mysql
@EntityListeners(Auditlistner.class)
@Entity

@Table(name="employee3")  //-->if class name and table is different use this instead of @Entity
//jp query
@NamedQuery(name="Employee.findbyIdAndEtype",
			//query = "select e from Employee e where e.id=?1 OR e.etype=?2 "
	query = "select e from Employee e where e.id=?1 OR e.etype='NONIT' "
		)
//@NamedNativeQuery(name="Employee.findbyFname",
//				query = "select * from Employee3 where fname=?1",
//				resultClass = Employee.class
//			)
public class Employee {
	private static Logger LOGGER = LoggerFactory.getLogger(Econtroller.class);
	@Id //making primary key
	@GeneratedValue(strategy=GenerationType.AUTO) //autoincreament
	@Column(name = "eid") //setting column name in the table
	private int id;
	@Column(name="ename")  //if not this -->automatically variable name will be given as column name
	//private String name;
	@Embedded 
	//name is a object -->having fname,lname
	private Ename name;
//	public Employee(int id, String name) {
//		// TODO Auto-generated constructor stub
//		super();
//		this.id=id;
//		this.name=name;
//	}
	public Employee() {
		// TODO Auto-generated constructor stub
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + "]";
//	}
	
	
	public Ename getName() {
		return name;
	}
	public void setName(Ename name) {
		this.name = name;
	}


	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//fetch type eager->when i load employe deatils the corresponding address also will be
	//loaded in onetoone eager will be activate by default
	//in Ont2Many and Many2One this is by default lazy
	//Reason-> in one2many if another table has more entry for same id of parent entry
	//thats why lazy will be deault in 2nd case
	private Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	//when new employee detail saved it also saved address details also
	//here it creates table in employee as a foreignkey
	//default name  of column =referencename_primarykey_column_nam
	//example here --> address_add_id
	//for customized columname us @joinColumn
	//@JoinColumn(name="fk_add_id") -->bydefault created automatically how ?
	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="emp_pro_id",referencedColumnName = "eid")
//	private List<Project> project;
//	public List<Project> getProject() {
//		return project;
//	}
//	public void setProject(List<Project> project) {
//		this.project = project;
//	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="emp_cont_id",referencedColumnName = "eid")
	private List<Contacts> contacts;
	public List<Contacts> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}
	
	
	public Etype getEtype() {
		return etype;
	}
	public void setEtype(Etype etype) {
		this.etype = etype;
	}


	@Enumerated(EnumType.STRING)
	private Etype etype;
	
//	@PrePersist
//    public void onPrePersist() {
//        LOGGER.info("Inserting={}",(new Date()).getTime());
//    }
}
