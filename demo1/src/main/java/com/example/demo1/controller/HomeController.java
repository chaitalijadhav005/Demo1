package com.example.demo1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.example.demo1.repository.StudentRepository;
import com.example.demo1.services.StudentService;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private StudentRepository studentRepository;

	

	List<Student> studentlist = new ArrayList<Student>();

	@GetMapping("/")
	public String getMessage() {
		return "chaitali";
	}

	@GetMapping("/student")
	public List<Student> getStudent() {
//		Student st = new Student();
//		st.setRoll(101);

//		st.setName("Ram");
//		st.setMarks(50);
//		studentlist.add(st);
//		return studentlist;
		return this.studentRepository.findAll();

	}

	@PostMapping("/")
	public Student addStudent(@RequestBody Student student) {
		System.out.println(student);
		// studentlist.add(student);
		return this.studentRepository.save(student);

	}

	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return this.studentRepository.findById(id).get();

	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable int id) {
		Student student = this.studentRepository.findById(id).get();
		this.studentRepository.delete(student);
		return "Student Deleted Successfully";
	}

	@PutMapping("/student/")
	public Student updateStudent(@RequestBody Student student) {
		Student ExitStudent = this.studentRepository.findById(student.getRoll()).get();
		ExitStudent.setName(student.getName());
		ExitStudent.setMarks(student.getMarks());
		return this.studentRepository.save(ExitStudent);

	}
}
