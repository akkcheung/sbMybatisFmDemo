package com.example.sbMybatisFmDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@Autowired
    private MessageService messageService;
	
	@GetMapping("/international")
    public String getInternationalPage(Model model) {
		
		model.addAttribute("greeting", messageService.getMessage("greeting"));
		
		model.addAttribute("lang_change", messageService.getMessage("lang.change"));
		model.addAttribute("lang_eng", messageService.getMessage("lang.eng"));
		model.addAttribute("lang_fr", messageService.getMessage("lang.fr"));
		
        return "international";
    }
}

