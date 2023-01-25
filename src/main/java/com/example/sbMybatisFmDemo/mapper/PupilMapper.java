package com.example.sbMybatisFmDemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.sbMybatisFmDemo.model.Pupil;
import com.example.sbMybatisFmDemo.model.Teacher;


@Mapper
public interface PupilMapper {

	@Select("select p.id as p_id, p.name as p_name, teacher_id from pupils p inner join teachers t on  p.teacher_id = t.id")
	@Results(value = { 
			@Result(property = "id", column = "p_id"), 
			@Result(property = "name", column = "p_name"),
			@Result(property = "teacher", javaType = Teacher.class, column = "teacher_id", one = @One(select = "getTeacherByPupil")) })
	List<Pupil> getPupils();
	
	@Select("select id, name from teachers where id=#{teacher_id}")
	public Teacher getTeacherByPupil(Integer teacher_id);
}
