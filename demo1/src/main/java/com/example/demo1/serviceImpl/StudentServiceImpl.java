package com.example.demo1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo1.ExceptionEntity.UserNotFoundException;
import com.example.demo1.entity.Student;
import com.example.demo1.repository.StudentRepository;
import com.example.demo1.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student creatUser(Student student) throws Exception {


	Student exitsing=	this.studentRepository.findByName(student.getName());
	
	
	     if(exitsing == null) {
	    return this.studentRepository.save(student);
	    	 
	     } 
	     throw new Exception("Already Student Exist: ");
		
	}

	@Override
	public Student updateStudent(Student student) throws Exception {
		Student existingStudent = this.findById(student.getRoll());

		if (student.getName() != null) {
			existingStudent.setName(student.getName());
		}
		if (student.getMarks() > 0) {
			existingStudent.setMarks(student.getMarks());
		}

		return this.studentRepository.save(existingStudent);

	}

	@Override
	public Student findById(@PathVariable int roll) throws Exception {
		Optional<Student> student = this.studentRepository.findById(roll);
		if (student.isEmpty()) {
			throw new UserNotFoundException("student not found with given roll" + roll);

		}
		return student.get();

	}

	@Override
	public List<Student> findAllStudent() {
		return this.studentRepository.findAll();

	}

	@Override
	public String deleteStudent(@PathVariable int roll) throws Exception {
		Student student = this.findById(roll);
		this.studentRepository.delete(student);
		return "Delete successfully..!";

	}

	@Override
	public Student findByName(String name) throws Exception {

		return this.studentRepository.findByName(name);

	}

}
