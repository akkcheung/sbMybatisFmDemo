package com.example.sbMybatisFmDemo.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import org.apache.ibatis.annotations.Many;

import com.example.sbMybatisFmDemo.model.Pupil;
import com.example.sbMybatisFmDemo.model.Teacher;

@Mapper
public interface TeacherMapper {

	// @Select("select t.id as t_id, t.name as t_name, p.id as p_id, p.name as
	// p_name from teachers t inner join pupils p on t.id = p.teacher_id")
	@Select("select t.id as t_id, t.name as t_name, p.id as p_id from teachers t inner join pupils p on t.id = p.teacher_id")
	@Results(value = { 
			@Result(property = "id", column = "t_id"), 
			@Result(property = "name", column = "t_name"),
			@Result(property = "pupils", javaType = List.class, column = "t_id", many = @Many(select = "getPupilsByTeacher")) })
	List<Teacher> getTeachers();
	
//	@Select("select t.id, t.name, p.id as p_id from teachers t inner join pupils p on t.id = p.teacher_id where t.id=#{id}")
//	@Results(value = { 
//			// @Result(property = "id", column = "t_id"), 
//			// @Result(property = "name", column = "t_name"),
//			@Result(property = "pupils", javaType = List.class, column = "id", many = @Many(select = "getPupilsbyTeacher")) })
//	Teacher getTeacherById(Integer id);

	// @Select("select id, name, teacher_id from pupils where teacher_id=#{t_id}")
	@Select("select id, name from pupils where teacher_id=#{t_id}")
	public Pupil getPupilsByTeacher(Integer t_id);

}
