package org.jsp.student_crud.service;

import java.util.List;
import java.util.Optional;

import org.jsp.student_crud.dao.StudentDao;
import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.exception.UserDefinedException;
import org.jsp.student_crud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public ResponseStructure<Student> save1(Student student) {
		student.setTotalmarks(student.getEnglish() + student.getKannada() + student.getMathematics());
		student.setPercentage(student.getTotalmarks() / 3);

		Student student1 = dao.save2(student);

		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setMessage("Data  Inserted Successfully");
		structure.setData(student1);
		// structure.setStatus(201);
		structure.setStatus(HttpStatus.CREATED.value());

		return structure;
	}

	public ResponseStructure<List<Student>> savemany(List<Student> students) {
		for(Student student :students)
		{
			student.setTotalmarks(student.getEnglish()+student.getKannada()+student.getMathematics());
			student.setPercentage(student.getTotalmarks()/3);
		}
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		structure.setMessage("Data  Inserted Successfully");
		structure.setData(dao.savemany(students));
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseStructure<Student> fetchById(int id) throws UserDefinedException {

		Optional<Student> optional = dao.fetchById(id);
		ResponseStructure<Student> structure = new ResponseStructure<>();
		if (optional.isEmpty()) {
		//	structure.setMessage("Data Not Found");
		//	structure.setStatus(HttpStatus.NOT_FOUND.value());
			throw new UserDefinedException("Id MissMatch");
		} else {
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(optional.get());
		}
		return structure;

	}

	public ResponseStructure<List<Student>> fetchByName(String name) throws UserDefinedException {
		
		List<Student> students = dao.fetchByName(name);
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		if (students.isEmpty()) {
			throw new UserDefinedException("Name MissMatch");
		//	structure.setMessage("Data Not Found");
		//	structure.setStatus(HttpStatus.NOT_FOUND.value());
		//	 structure.setData(students);

		} else {
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(students);
		}
		return structure;
	}

	public ResponseStructure<List<Student>> fetchAll() throws UserDefinedException {

		List<Student> students = dao.fetchAll();
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		if (students.isEmpty()) {
			throw new UserDefinedException("Url MissMatch so enter proper URL");
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(students);
		} else {
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(students);
		}
		return structure;
	}

	public ResponseStructure<List<Student>> fetchByMobile(long mobile) throws UserDefinedException {
		List<Student> students = dao.fetchByMobile(mobile);
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		if (students.isEmpty()) 
		{
			throw new UserDefinedException("Mobile Number MissMatch");
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());

		} else {
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(students);
		}
		return structure;
	}

	public ResponseStructure<List<Student>> fetchByStandard(String standard) throws UserDefinedException {
		// TODO Auto-generated method stub
		List<Student> students = dao.fetchByStandard(standard);
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		if (students.isEmpty()) 
		{
			throw new UserDefinedException("Standard MissMatch");
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(students);
		}
		return structure;
	}

	public ResponseStructure<List<Student>> fetchmaxpercentage() throws UserDefinedException {
		
		List<Student> student = dao.fetchMaxPercentage();
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		if(student.isEmpty()) 
		{
			throw new UserDefinedException("Percentage MissMatch");
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
		}
		return structure;
	}
	public ResponseStructure<List<Student>> fetchDistinction() throws UserDefinedException {
		List<Student> student=dao.fetchdistinction();
		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		if(student.isEmpty())
		{
			throw new UserDefinedException("Distinction student data is not there");
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		else {
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
		}
		return structure;
	}
	public ResponseStructure<List<Student>> firstClass() throws UserDefinedException {
		// TODO Auto-generated method stub
		List<Student> student = dao.fetchfirstclass();
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		if(student.isEmpty()) 
		{
			throw new UserDefinedException("firstclass student data is not there");
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
		}
		return structure;
	}
	public ResponseStructure<List<Student>> fail() throws UserDefinedException {
		List<Student> student=dao.fail();
		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		if(student.isEmpty())
		{
			throw new UserDefinedException("failed student data is not there");
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}else {
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
		}
		return structure;
	} 
	public ResponseStructure<Student> update1(Student student) {
		student.setTotalmarks(student.getEnglish() + student.getKannada() + student.getMathematics());
		student.setPercentage(student.getTotalmarks() / 3);

		Student student1 = dao.update1(student);

		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setMessage("Data Updated Successfully");
		structure.setData(student1);
		structure.setStatus(HttpStatus.ACCEPTED.value());
		
		return structure;
	}

	public ResponseStructure<Student> delete(int id) throws UserDefinedException {
		Optional<Student> optional = dao.fetchById(id);
		ResponseStructure<Student> structure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			throw new UserDefinedException("Id MissMatch");
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			dao.delete(id);
			structure.setMessage("Data deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(optional.get());
		}
		return structure;
	}
}
