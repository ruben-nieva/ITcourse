package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.entity.Course;
import com.demo.repository.CourseRepository;

import java.util.List;

@Controller
public class CourseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
		
	@Autowired
	private CourseRepository courseRepository;


    @ModelAttribute("courses")
    public List<Course> PopulateCourses(Model model){        
		 return courseRepository.findAll();
    }
    
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String persons(Model model){
        model.addAttribute("pagina", "cursos");
        model.addAttribute("listadoCursos", this.courseRepository.findAll());
        return "showCourses";
    }
	
	@RequestMapping(value = "/{courseName}", method = RequestMethod.GET)
	public String showCoure(@PathVariable() String courseName, Model model){
		
		LOGGER.debug("Rendering vew for Course:" + courseName);
		
		Course course= courseRepository.findByName(courseName);
		
		if ( course==null ){			
			LOGGER.debug("Course not found: " +  courseName);
			return "form";
		}
		
		model.addAttribute("courseName", courseName);
		model.addAttribute("courseDescription", course.getDescription());
		
		return "course";
	}

}
