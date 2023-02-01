package com.example.sbMybatisFmDemo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.sbMybatisFmDemo.mapper.StudentMapper;
import com.example.sbMybatisFmDemo.model.Student;

@SpringBootTest
public class StudentServiceTest {

	@Autowired
	StudentMapper studentMapper;
	
	@Test
	public void testStudentsList() throws Exception {
				
		List <Student> students = studentMapper.findAllStudents();
		assertThat(students.get(0).getName().equals("aa"));
		assertThat(students.size()).isEqualTo(3);
		
	}
}
