package com.example.demo.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Entity
@Data
public class Address implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int houseNo;
	private int laneNo;
	private String street;
	private String city;
	private String district;
	private String state;
	@OneToOne(mappedBy = "address",
			cascade = CascadeType.ALL)
	private Student student;
	
	public Address(int houseNo, int laneNo, String street, String city, String district, String state) {
		this.houseNo = houseNo;
		this.laneNo = laneNo;
		this.street = street;
		this.city = city;
		this.district = district;
		this.state = state;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public int getLaneNo() {
		return laneNo;
	}
	public void setLaneNo(int laneNo) {
		this.laneNo = laneNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Address() {
		
	}
	
}
