package com.example.sbMybatisFmDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.sbMybatisFmDemo.model.Greeting;

@Controller
public class GreetRestController {
	
	@GetMapping("/greet")
	public String showAdd(Model model) {
		return "greeting";
	}
	
	@PostMapping("/greet")
    @ResponseBody
	public String greet(@ModelAttribute Greeting values) {
		return "Hello " + values.getValue() + "!";
	}
	
	
}
