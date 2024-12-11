package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.Student_Service;

@Controller
public class Student_Controller {
	@Autowired
	private Student_Service student_Service;
	
	@GetMapping("/home")
	public String home() {
		return"home";
	}
	@GetMapping("/students")
	public String getAllStudent(Model model) {
		model.addAttribute("students", student_Service.getAllData());
		return "students";
		
	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student= new Student();
		model.addAttribute("student",student);
		return"create-student";
		
	}
	@PostMapping("/students")
	public String saveAllStudent(@ModelAttribute("student") Student student) {
		student_Service.saveAllStudent(student);
		return"redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id,Model model) {
		model.addAttribute("student", student_Service.getById(id));
		return"edit-student";
		
	}
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("student")Student student) {
		Student std = student_Service.getById(id);
		std.setfName(student.getfName());
		std.setlName(student.getlName());
		std.setEmail(student.getEmail());
		std.setAge(student.getAge());
		student_Service.saveAllStudent(std);
		return"redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id) {
		student_Service.deleteById(id);
		return"redirect:/students";
	}

}
