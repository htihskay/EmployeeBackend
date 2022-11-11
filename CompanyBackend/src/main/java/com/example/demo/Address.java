package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address3")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="add_id")
	private int add_id;
	private String city;
	private int pincode;
//	@OneToOne
//	@JoinColumn(name="add_id",referencedColumnName = "eid")
//	private Employee empoyee;
	public int getAdd_id() {
		return add_id;
	}
	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
//	public Employee getEmpoyee() {
//		return empoyee;
//	}
//	public void setEmpoyee(Employee empoyee) {
//		this.empoyee = empoyee;
//	}

}
