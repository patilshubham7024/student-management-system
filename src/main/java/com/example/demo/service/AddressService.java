package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Address;
import com.example.demo.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository repository;

	public List<Address> showAddress(List<Integer> rollNo) {
		return (List<Address>) repository.findAllById(rollNo);
	}

	public String add(Address address) {
		try {
			repository.save(address);
			return address.getHouseNo() + " added.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String delete(int houseNo) {
		try {
			repository.deleteById(houseNo);
			return houseNo + " has been deleted.";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
