package com.example.sbMybatisFmDemo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.sbMybatisFmDemo.mapper.StudentMapper;
import com.example.sbMybatisFmDemo.model.Student;

import jakarta.validation.Valid;

@Controller
public class StudentController {

	StudentMapper studentMapper;

//	@Value("${error.message}")
//	private String errorMessage;

	public StudentController(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@RequestMapping(value = { "/students/list" }, method = RequestMethod.GET)
	public String studentList(Model model) {

		List<Student> students = studentMapper.findAllStudents();

		model.addAttribute("students", students);

		return "student-list";
	}

	@RequestMapping(value = { "/students/add" }, method = RequestMethod.GET)
	public String showAdd(Model model) {

		Student student = new Student() ;
		
		model.addAttribute("add", true);
		model.addAttribute("student", student);

		return "student-edit";
	}

	@PostMapping(value = "/students/add")
	public String add(
			@Valid Student student, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("student", student);
			model.addAttribute("add", true);

			return "student-edit";
		}

		studentMapper.insertStudent(student);
		return "redirect:/students/list";

	}
	
	@GetMapping(value = "/students/{id}")
	public String getById(Model model, @PathVariable long id) {

	    Student student = null;
	    
	    try {
	    	student = studentMapper.findStudentById(id);
	        model.addAttribute("allowDelete", false);

	    } catch (Exception ex) {
	        model.addAttribute("errorMessage", ex.getMessage());
	    }

	    model.addAttribute("student", student);        
	    return "student";

	}
	
	@GetMapping(value = {"/students/{id}/edit"})
	public String showEdit(Model model, @PathVariable long id) {

		Student student = null;
	    try {
	    	student = studentMapper.findStudentById(id);

	    } catch (Exception ex) {
	        model.addAttribute("errorMessage", ex.getMessage());

	    }

	    model.addAttribute("add", false);
	    model.addAttribute("student", student);  

	    return "student-edit";

	}
	
	@PostMapping(value = { "/students/{id}/edit" })
	public String update(@Valid Student student, BindingResult bindingResult, Model model, @PathVariable long id
	) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("student", student);
			model.addAttribute("add", false);

			return "student-edit";
		}

		studentMapper.updateStudent(student, id);
		return "redirect:/students/" + String.valueOf(student.getId());

	}
	
	@GetMapping(value = {"/students/{id}/delete"})
	public String showDeleteById(
	    Model model, @PathVariable long id) {
	    
		Student student = null;
	    try {
	    	student = studentMapper.findStudentById(id);

	    } catch (Exception ex) {
	        model.addAttribute("errorMessage", ex.getMessage());

	    }

	    model.addAttribute("allowDelete", true);
	    model.addAttribute("student", student);

	    return "student";

	}
	
    @PostMapping(value = {"/students/{id}/delete"})

    public String deleteById(
    		 Model model, @PathVariable long id) {
        try {
        	studentMapper.deleteStudent(id);
            return "redirect:/students/list";

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            //logger.error(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            return "students-edit";

        }
    }
}
