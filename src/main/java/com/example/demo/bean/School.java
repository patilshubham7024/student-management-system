package com.example.demo.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class School implements Serializable{
	@Id
	private int regNo;
	private String name;
	private int capacity;
	private boolean aided;
}
