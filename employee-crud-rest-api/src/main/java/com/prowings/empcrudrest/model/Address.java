package com.prowings.empcrudrest.model;

import java.beans.Transient;
import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int addressId;
	
	@Column
	private String city;
	
	@Column
	private int pin ;
	
	@OneToOne(mappedBy = "address")
	@JsonBackReference
	private Employee employee;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", pin=" + pin + "]";
	}
	
	
	
}
