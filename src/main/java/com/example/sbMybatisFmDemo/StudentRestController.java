package com.example.sbMybatisFmDemo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.sbMybatisFmDemo.mapper.StudentMapper;
import com.example.sbMybatisFmDemo.model.Student;

@RestController
// @RequestMapping(value = "/", consumes = "application/json", produces = "application/json")
public class StudentRestController {

	// @Autowired
	StudentMapper studentMapper;
	
	public StudentRestController(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	// @GetMapping("/findAllStudents")
	@GetMapping("/v1/students")
	public List<Student> findAllStudents() {
		return studentMapper.findAllStudents();
		
	}

	@GetMapping("/v1/students/{id}")
	public Student findStudentById(@PathVariable("id") int id) {
		return studentMapper.findStudentById(id);
		
	}
	
	// @PostMapping("/insertStudent")
	@PostMapping("/v1/students")
	public void insertStudent(@RequestBody Student student) {
		studentMapper.insertStudent(student);
	}

	// @PutMapping("/updateStudent/{id}")
	@PutMapping("/v1/students/{id}")
	public void updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
		studentMapper.updateStudent(student, id);
	}

	// @DeleteMapping("/deleteStudent/{id}")
	@DeleteMapping("/v1/students/{id}")
	public void deleteStudent(@PathVariable("id") int id) {
		studentMapper.deleteStudent(id);
	}
	
	

}
