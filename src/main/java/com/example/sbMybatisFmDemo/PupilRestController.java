package com.example.sbMybatisFmDemo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbMybatisFmDemo.mapper.PupilMapper;
import com.example.sbMybatisFmDemo.mapper.StudentMapper;
import com.example.sbMybatisFmDemo.mapper.TeacherMapper;
import com.example.sbMybatisFmDemo.model.Pupil;
import com.example.sbMybatisFmDemo.model.Teacher;

@RestController
public class PupilRestController {
	
	PupilMapper pupilMapper;

	public PupilRestController(PupilMapper pupilMapper) {
		this.pupilMapper = pupilMapper;
	}

	@GetMapping("/v1/pupils")
	public List<Pupil> getPupils(){
		
		return pupilMapper.getPupils();
	
			

	}
}
