package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentModel {
	
	private int id;
	private String name;
	private String address;
	private String school;
	
}
