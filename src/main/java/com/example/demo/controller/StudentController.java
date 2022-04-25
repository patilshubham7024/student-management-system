package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/show")
	public List<Student> showStudent(@RequestParam List<Integer> rollNo) {
		return service.showStudent(rollNo);
	}
	
	@PostMapping("/add")
	public String add(@RequestBody Student student) {
		return service.add(student);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam int rollNo) {
		return service.delete(rollNo);
	}
	@PostMapping("/addAll")
	public String addAll(@RequestBody List<Student> students) {
		return service.addAll(students);
	}
	@GetMapping("/use-filter")
	public List<Student> getList(@RequestParam List<String> sName,
								 @RequestParam List<Integer> rollNo
								 ){
		return service.getList(sName, rollNo);
	}
}
