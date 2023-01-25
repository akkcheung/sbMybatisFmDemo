package com.example.sbMybatisFmDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import com.example.sbMybatisFmDemo.mapper.StudentMapper;

@SpringBootApplication
@EnableJdbcHttpSession
public class SbMybatisFmDemoApplication {

	private final StudentMapper studentMapper;

	public SbMybatisFmDemoApplication(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(SbMybatisFmDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println(this.studentMapper.findAllStudents());

		};

	}
}
