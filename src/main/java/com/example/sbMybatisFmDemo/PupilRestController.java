package com.example.sbMybatisFmDemo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbMybatisFmDemo.mapper.PupilMapper;
import com.example.sbMybatisFmDemo.model.Pupil;

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
