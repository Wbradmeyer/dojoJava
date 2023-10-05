package com.brad.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brad.studentroster.models.Dorm;
import com.brad.studentroster.models.Student;
import com.brad.studentroster.repositories.DormRepository;

@Service
public class DormService {
	
	@Autowired
	private DormRepository dormRepo;
	
	public List<Dorm> allDorms() {
		return dormRepo.findAll();
	}
	
	public Dorm find(Long id) {
		return dormRepo.findById(id).orElse(null);
	}
	
	public Dorm create(Dorm dorm) {
		return dormRepo.save(dorm);
	}
	
	public void addStudent(Dorm dorm, Student student) {
		dorm.getStudents().add(student);
		dormRepo.save(dorm);
	}
	
	public Dorm update(Dorm dorm) {
		return dormRepo.save(dorm);
	}
	
	public void delete(Long id) {
		dormRepo.deleteById(null);
	}
}
