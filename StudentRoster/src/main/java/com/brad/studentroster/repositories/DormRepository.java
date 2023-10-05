package com.brad.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brad.studentroster.models.Dorm;

public interface DormRepository extends CrudRepository<Dorm, Long> {
	
	List<Dorm> findAll();
}
