package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Address;
import com.example.demo.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService service;
	
	@GetMapping("/show")
	public List<Address> showAddress(@RequestParam List<Integer> houseNo) {
		return service.showAddress(houseNo);
	}
	
	@PostMapping("/add")
	public String addAddress(@RequestBody Address Address) {
		return service.add(Address);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam int houseNo) {
		return service.delete(houseNo);
	}
	
}
