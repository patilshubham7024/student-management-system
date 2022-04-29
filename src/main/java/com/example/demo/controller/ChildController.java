package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Child;
import com.example.demo.service.ChildService;

@RestController("/child")
public class ChildController {
	
	@Autowired
	private ChildService service;
	
	@PostMapping("/add")
	public String add(@Valid @RequestBody Child child, BindingResult result) {
		return result.hasErrors()
				?result.getFieldError().getDefaultMessage()
				:service.add(child);
	}
}
