package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Student;

public interface StudentRepoPDF extends JpaRepository<Student,Long > {

}
