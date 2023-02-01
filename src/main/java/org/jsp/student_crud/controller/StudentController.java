package org.jsp.student_crud.controller;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.exception.UserDefinedException;
import org.jsp.student_crud.helper.ResponseStructure;
import org.jsp.student_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {

	@Autowired
	StudentService service;

	// Create only 1 student data
	@PostMapping("saveone")
	public ResponseStructure<Student> saveone(@RequestBody Student student) {
//		student.setTotalmarks(student.getEnglish()+student.getKannada()+student.getMathematics());
//		student.setPercentage(student.getTotalmarks()/3);
//		return student;
//		
		return service.save1(student);
	}

	// Create multiple student data
	@PostMapping("savemany")
	public ResponseStructure<List<Student>> savemany(@RequestBody List<Student> students) {
		return service.savemany(students);
	}

	// Retrive by id url rewritting
	@GetMapping("fetch")
	public ResponseStructure<Student> fetchById(@RequestParam int id) throws UserDefinedException {
		return service.fetchById(id);

	}

	// Retrive by id path variable
	@GetMapping("fetch/{id}")
	public ResponseStructure<Student> fetchByIdPathVariable(@PathVariable int id) throws UserDefinedException {
		return service.fetchById(id);
	}

	// Retrive By Name
	@GetMapping("fetchbyname/{name}")
	public ResponseStructure<List<Student>> fetchByName(@PathVariable String name) throws UserDefinedException {
		return service.fetchByName(name);
	}

	// Retrive All the data from database
	@GetMapping("fetchall")
	public ResponseStructure<List<Student>> fetchAll() throws UserDefinedException {
		return service.fetchAll();
	}

	// Retrive By Mobile
	@GetMapping("fetchbymobile/{mobile}")
	public ResponseStructure<List<Student>> fetchByMobile(@PathVariable long mobile) throws UserDefinedException {
		return service.fetchByMobile(mobile);
	}

	// Retrive by standard
	@GetMapping("fetchbystd/{Standard}")
	public ResponseStructure<List<Student>> fetchByStandard(@PathVariable String Standard) throws UserDefinedException {
		return service.fetchByStandard(Standard);
	}

	// Retrive by max percentage
	@GetMapping("fetchmaxpercentage")
	public ResponseStructure<List<Student>> fetchMaxPercentage() throws UserDefinedException {
		return service.fetchmaxpercentage();
	}

	// Retrive by distinction
	@GetMapping("distinction")
	public ResponseStructure<List<Student>> distinction() throws UserDefinedException {
		return service.fetchDistinction();
	}

	// Retrive by firstclass
	@GetMapping("firstclass")
	public ResponseStructure<List<Student>> firstclass() throws UserDefinedException {
		return service.firstClass();
	}

	// Retrive by fail students
	@GetMapping("fail")
	public ResponseStructure<List<Student>> fail() throws UserDefinedException {
		return service.fail();

	}

	// update
	@PutMapping("update")
	public ResponseStructure<Student> update(@RequestBody Student student) {
		return service.update1(student);
	}

	// delete by id
	@DeleteMapping("delete/{id}")
	public ResponseStructure<Student> delete(@PathVariable int id) throws UserDefinedException {
		return service.delete(id);
	}

}
