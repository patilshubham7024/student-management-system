package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo.bean.Child;
import com.example.demo.repository.ChildRepository;

@Service
public class ChildService {
	@Autowired
	private ChildRepository repository;

	public String add(Child child) {
		return 
		repository.save(child).getName() + " added successfully!";
	}

}
