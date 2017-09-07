package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDTO;
import com.app.model.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping(value="api/studenti")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//StudijskiProgramService
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.findAll();
		
		return new ResponseEntity<>(students, HttpStatus.OK);
		
	}
	
	/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudentsPage(Pageable page){
		Page<Student> pageStudents = studentService.findAll(page);
		List<Student> students = new ArrayList<>();
		for(Student s : pageStudents){
			students.add(s);
		}
		return new ResponseEntity<>(students, HttpStatus.OK);
	}*/
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO student){
		System.out.println("student" + student);
		Student s = new Student();
		
		s.setIme(student.getIme());
		s.setPrezime(student.getPrezime());
		s.setUserName(student.getUsername());
		s.setPassword(student.getPassword());
		s.setEmail(student.getEmail());
		s.setIndeks(student.getIndeks());
		
		s = studentService.save(s);
		
		return new ResponseEntity<>(new StudentDTO(s), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Student> updateStudent(@RequestBody Student s){
		//a student must exist
		Student student = studentService.findOne(s.getId()); 
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		student = studentService.save(student);
		return new ResponseEntity<>(student, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if (student != null){
			studentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
