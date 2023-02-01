package org.jsp.student_crud.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {

	@Autowired
	StudentRepository repository;

	public Student save2(Student student) {
		// Persistence.createEntityManagerFactory("dev");
		return repository.save(student);
	}

	public List<Student> savemany(List<Student> students) {
		// TODO Auto-generated method stub
		return repository.saveAll(students);
	}

	public Optional<Student> fetchById(int id) {
		return repository.findById(id);// find By id is a inbuilt method
	}

	public List<Student> fetchByName(String name) {
		return repository.findByName(name);
	}

	public List<Student> fetchAll() {
		return repository.findAll();
	}

	public List<Student> fetchByMobile(long mobile) {
		// TODO Auto-generated method stub
		return repository.findByMobile(mobile);
	}

	public List<Student> fetchByStandard(String standard) {
		// TODO Auto-generated method stub
		return repository.findByStandard(standard);
	}

	public List<Student> fetchMaxPercentage() {
		// TODO Auto-generated method stub
		return repository.fetchdMaxPercentage();
	}

	public List<Student> fetchdistinction() {
		// TODO Auto-generated method stub
		return repository.distinction();
	}

	public List<Student> fetchfirstclass() {
		// TODO Auto-generated method stub
		return repository.firstClass();
	}

	public List<Student> fail() {
		return repository.fail();
	}

	public Student update1(Student student) {
		return repository.save(student);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}
}
