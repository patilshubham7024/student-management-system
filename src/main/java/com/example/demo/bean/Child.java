package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.demo.model.Gender;

import lombok.Data;

@Entity
@Data
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value = 100000, message = "Adhar no should be minimum 6 digits!")
	private int adhar;
	@NotBlank(message = "Name is mandatory.")
	private String name;
	private int age;
	private Gender gender;

	@Override
	public String toString() {
		return "Child [adhar=" + adhar + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	public Child() {
	}

	public Child(int adhar, String name, int age, Gender gender) {
		super();
		this.adhar = adhar;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public int getAdhar() {
		return adhar;
	}

	public void setAdhar(int adhar) {
		this.adhar = adhar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
