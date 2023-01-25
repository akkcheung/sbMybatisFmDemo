package com.example.sbMybatisFmDemo;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

//	@GetMapping("/")
//	public String index() {
//		return "Greetings from Spring Boot!";
//	}

	@GetMapping("/hello")
	public ModelAndView home() {
		// model.addAttribute("name", "kk");
		
		var params = new HashMap<String, Object>();
		params.put("name", "kk");

		return new ModelAndView("hello", params);
	}

}
