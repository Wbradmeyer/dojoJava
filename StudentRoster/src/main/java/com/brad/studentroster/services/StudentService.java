package com.brad.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brad.studentroster.models.ClassEx;
import com.brad.studentroster.models.Dorm;
import com.brad.studentroster.models.Student;
import com.brad.studentroster.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> allStudents() {
		return studentRepo.findAll();
	}
	
	public Student find(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	public List<Student> studentsByClass(ClassEx classEx) {
		return studentRepo.findAllByClasses(classEx);
	}
	
	public Student create(Student student) {
		return studentRepo.save(student);
	}
	
	public Student update(Student student) {
		return studentRepo.save(student);
	}
	
	public void delete(Long id) {
		studentRepo.deleteById(null);
	}
}
