package com.example.demo1.services;

import java.util.List;

import com.example.demo1.entity.Student;

public interface StudentService  {
	public Student creatUser(Student student) throws Exception;
	 public Student updateStudent( Student student) throws Exception;
	public Student findById(int roll) throws Exception;
	public List<Student> findAllStudent();
	public String deleteStudent(int roll) throws Exception;
	 
	public Student findByName(String name)throws Exception;
	
}
