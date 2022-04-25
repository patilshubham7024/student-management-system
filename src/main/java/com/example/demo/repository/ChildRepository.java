package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.Child;

public interface ChildRepository extends CrudRepository<Child, Integer>{

}
