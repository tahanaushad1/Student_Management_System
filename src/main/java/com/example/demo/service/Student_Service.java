package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface Student_Service {
	public List<Student>getAllData();
	public Student saveAllStudent(Student student);
	public Student getById(int id);
	public void deleteById(int id);

}
