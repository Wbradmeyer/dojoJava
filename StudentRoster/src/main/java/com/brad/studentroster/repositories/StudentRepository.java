package com.brad.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brad.studentroster.models.ClassEx;
import com.brad.studentroster.models.Dorm;
import com.brad.studentroster.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findAll();
	
	List<Student> findAllByClasses(ClassEx classEx);
	
	List<Student> findByClassesNotContaining(ClassEx classEx);

}
