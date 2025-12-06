package com.example.demo1.entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
//@Data  both are in data getter and setter
@NoArgsConstructor//empty constructor by using super class
@AllArgsConstructor// it makes parameterized constructor
@Builder// we can build object 
@ToString// to represent object representation
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roll;
	@NotBlank
	private String name;
	private float marks;
	@Email
	private String email;
	
	
	

}
