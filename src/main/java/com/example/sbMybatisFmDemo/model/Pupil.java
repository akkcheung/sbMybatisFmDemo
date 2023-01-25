package com.example.sbMybatisFmDemo.model;

public class Pupil {

	private Integer id;
	private String name;
	private Teacher teacher;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

//	public Integer getTeacherId() {
//		return teacherId;
//	}
//
//	public void setTeacherId(Integer teacherId) {
//		this.teacherId = teacherId;
//	}

}
