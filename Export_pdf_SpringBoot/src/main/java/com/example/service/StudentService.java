package com.example.service;

import java.util.List;

import com.example.entity.Student;

public interface StudentService {

	void addstudent(Student student);
	List<Student> getStudentList();
}
