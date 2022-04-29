package com.example.demo.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Child;
import com.example.demo.bean.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	@PersistenceContext
	EntityManager manager;

	public List<Student> showStudent(Iterable<Integer> rollNo) {
		return (List<Student>) repository.findAllById(rollNo);
	}

	public String add(Student student) {
		try {
			int min = Calendar.getInstance().get(13);
			int sec = Calendar.getInstance().get(14);
			return repository.save(student).getRollNo() + " added successfully. ---> " + " " + "-->>"
					+ (Calendar.getInstance().get(13) - min) + ":" + (Calendar.getInstance().get(14) + sec);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String delete(int rollNo) {
		try {
			int min = Calendar.getInstance().get(13);
			int sec = Calendar.getInstance().get(14);
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaDelete<Student> delete = builder.createCriteriaDelete(Student.class);
			Root<Student> root = delete.from(Student.class);
			delete.where(builder.lessThan(root.get("rollNo"), 100000));
			int createQuery = manager.createQuery(delete).executeUpdate();
			System.out.println(createQuery);
			String end = (Calendar.getInstance().get(13) - min) + ":" + (Calendar.getInstance().get(14) + sec);
			return rollNo + " deleted successfully." + end;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public String addAll(List<Student> students) {
		return repository.saveAll(students).toString() + " added successfully.";
	}

	public List<Student> getList(List<String> sName, List<Integer> rollNo) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);

		CriteriaQuery<Student> select = query.select(root);

		List<Predicate> predicates = new ArrayList<Predicate>();
//									predicates.add(root.get("rollNo").in(rollNo));
//									predicates.add(root.get("sName").in(sName));
		predicates.add(builder.between(root.get("rollNo"), rollNo.get(0), rollNo.get(1)));
		predicates.add(builder.equal(root.get("sName"), sName));
//									query.where(builder.or(predicates.toArray(new Predicate[0])));
		query.where(builder.and(predicates.toArray(new Predicate[0])));
		Query createQuery = manager.createQuery(select);
		System.out.println(predicates.toArray(new Predicate[0]));

		List<Student> list = createQuery.getResultList();
		System.out.println(list);
		return list;
	}

	public List<Child> testJoin() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Child> query = builder.createQuery(Child.class);
		
		return null;
	}
}