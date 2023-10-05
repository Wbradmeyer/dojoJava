package com.brad.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brad.studentroster.models.ClassEx;
import com.brad.studentroster.models.Student;

public interface ClassRepository extends CrudRepository<ClassEx, Long> {

	List<ClassEx> findAll();
	
	List<ClassEx> findAllByStudents(Student student);
	
	List<ClassEx> findByStudentsNotContaining(Student student);
}
