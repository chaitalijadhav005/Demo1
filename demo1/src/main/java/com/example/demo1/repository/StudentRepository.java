package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	 
public Student findByName(String name);
}
