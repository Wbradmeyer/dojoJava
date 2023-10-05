package com.brad.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brad.studentroster.models.ClassEx;
import com.brad.studentroster.repositories.ClassRepository;

@Service
public class ClassService {
	
	@Autowired
	private ClassRepository classRepo;
	
	public List<ClassEx> allClasses() {
		return classRepo.findAll();
	}
	
	public ClassEx find(Long id) {
		return classRepo.findById(id).orElse(null);
	}
	
	public ClassEx create(ClassEx classEx) {
		return classRepo.save(classEx);
	}
	
	public ClassEx update(ClassEx classEx) {
		return classRepo.save(classEx);
	}
	
	public void delete(Long id) {
		classRepo.deleteById(null);
	}
}
