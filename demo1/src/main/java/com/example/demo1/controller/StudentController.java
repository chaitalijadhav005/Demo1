package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.entity.Student;
import com.example.demo1.services.StudentService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/student")
public class StudentController {
@Autowired
private StudentService studentService;

@PostMapping
public Student creatStudent(@Valid @RequestBody Student student)throws Exception {
	return this.studentService.creatUser(student);
}
@PutMapping
public Student updateStudent(@Valid @RequestBody Student student) throws Exception {
	
	 return	 this.studentService.updateStudent(student);
	
	 
	

}
@GetMapping
public List<Student> findAllStudent(){
	return this.studentService.findAllStudent();
}
@GetMapping("/{id}")
public Student findById(@PathVariable  int id) throws Exception {
	return this.studentService.findById(id);
}
@DeleteMapping("/{id}")
public String deleteStudent(@PathVariable  int id) throws Exception {
	return this.studentService.deleteStudent(id);
} 
@GetMapping("/name/{name}")

public Student findByName(@PathVariable String name)throws Exception{
	return this.studentService.findByName(name);
	
}



}
