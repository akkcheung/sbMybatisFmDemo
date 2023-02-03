package com.example.sbMybatisFmDemo;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbMybatisFmDemo.mapper.TeacherMapper;
import com.example.sbMybatisFmDemo.model.Teacher;

@RestController
public class TeacherRestController {

	TeacherMapper teacherMapper;

	public TeacherRestController(TeacherMapper teacherMapper) {
		this.teacherMapper = teacherMapper;
	}

	@GetMapping("/api/v1/teachers")
	public List<Teacher> getTeachers() {
		// return teacherMapper.getTeachers();
		List <Teacher> results = teacherMapper.getTeachers();
		
		Set<Teacher> set = new HashSet<>(teacherMapper.getTeachers());
		results.clear();
		results.addAll(set);
		
		return results;

	}
	
//	@GetMapping("/v1/teachers/{id}")
//	public Teacher getTeacherById(@PathVariable("id") int id) {
//		return teacherMapper.getTeacherById(id);
//		
//	}

}
