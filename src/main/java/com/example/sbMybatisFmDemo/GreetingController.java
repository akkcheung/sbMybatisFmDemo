package com.example.sbMybatisFmDemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class GreetingController {
	
	@GetMapping("/messages")
    public @ResponseBody ResponseEntity<List> getMessage(Model model, HttpSession session) {
        List greetings = (List) session.getAttribute("GREETING_MESSAGES");
        if(greetings == null) {
            greetings = new ArrayList<>();
        }

        return new ResponseEntity<List>(greetings,HttpStatus.OK);
    }

    @PostMapping("/messages")
    public @ResponseBody ResponseEntity<List> saveMessage(@RequestParam("message") String greeting, HttpServletRequest request)
    {
        List greetings = (List) request.getSession().getAttribute("GREETING_MESSAGES");
        if(greetings == null) {
            greetings = new ArrayList<>();
            request.getSession().setAttribute("GREETING_MESSAGES", greetings);
        }
        greetings.add(greeting);
        
        System.out.println("greetings size " + greetings.size());
        
        return new ResponseEntity<List>(greetings,HttpStatus.OK);
    }
}
