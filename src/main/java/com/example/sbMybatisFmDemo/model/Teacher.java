package com.example.sbMybatisFmDemo.model;

import java.util.List;

public class Teacher {
	
	private Integer id;
	private String name;
	private List<Pupil> pupils;
	
	
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
	public List<Pupil> getPupils() {
		return pupils;
	}
	public void setPupils(List<Pupil> pupils) {
		this.pupils = pupils;
	}
	
}
