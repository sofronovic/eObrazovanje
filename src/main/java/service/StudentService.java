package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Student;
import repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student findOne(Long id){
		return studentRepository.findOne(id);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student save(Student student){
		return studentRepository.save(student);
	}
	
	public void remove(Long id){
		studentRepository.delete(id);
	}
}
