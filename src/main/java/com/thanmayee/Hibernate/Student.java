package com.thanmayee.Hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private int studentId;
	private StudentName name;
	private int age;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public StudentName getName() {
		return name;
	}

	public void setName(StudentName name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", age=" + age + "]";
	}
}
