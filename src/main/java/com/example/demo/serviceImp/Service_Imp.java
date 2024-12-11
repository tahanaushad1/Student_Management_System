package com.example.demo.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.Student_Repo;
import com.example.demo.service.Student_Service;
@Service
public class Service_Imp implements Student_Service{
	@Autowired
	private Student_Repo student_Repo;

	@Override
	public List<Student> getAllData() {
		
		List<Student>list= student_Repo.findAll();
		return list;
	}

	@Override
	public Student saveAllStudent(Student student) {
		return student_Repo.save(student);
		
	}

	@Override
	public Student getById(int id) {
		return student_Repo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		student_Repo.deleteById(id);
		
	}

}
