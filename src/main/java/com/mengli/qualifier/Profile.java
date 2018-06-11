package com.mengli.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {

	public Profile() {
		System.out.println("inner constructor");
	}
	@Autowired
	@Qualifier("student2")
	
	private Student student;
	public void printAge() {
		System.out.println("age=="+student.getAge());
	}
	public void printName() {
		System.out.println("name==="+student.getName());
	}

}
