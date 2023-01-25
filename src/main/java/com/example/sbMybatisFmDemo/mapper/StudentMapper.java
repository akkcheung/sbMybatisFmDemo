package com.example.sbMybatisFmDemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.sbMybatisFmDemo.model.Student;

@Mapper
public interface StudentMapper {
	
	@Select("select * from Students")
	List<Student> findAllStudents();
	
	@Select("select * from Students where id=#{id}")
	Student findStudentById(long id);
	
	@Insert("insert into Students (name,email) values (#{name},#{email})")
	void insertStudent(Student student);
	
	@Update("update Students set name=#{student.name},email=#{student.email} where id=#{id}")
	void updateStudent(Student student,long id);
	
	@Delete("delete from Students where id=#{id}")
	void deleteStudent(long id);
}
