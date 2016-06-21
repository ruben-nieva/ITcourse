package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    public String listarCursos(Model model){
        model.addAttribute("pagina", "cursos");
        model.addAttribute("listadeCursos", this.courseRepository.findAll());
        return "showCourses";
    }
    
    
    @RequestMapping(value="/newCourse")
    public String newCourse(ModelMap model) {
        model.addAttribute("pagina", "course");
        model.addAttribute("nuevocurso", new Course());
        return "newCourse";
    }
    
    
    @RequestMapping(value = "course", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute Course course, BindingResult bindingResult, final ModelMap model){
    	
    	//Add validation function to avoid malformed object 
    	  	
    	LOGGER.debug("Rendering POST ADD COURSE" + course.getName());
    	
    	if ( courseRepository.findByName(course.getName()) == null){    		
    		courseRepository.save(course);    		
    	}else{
    		LOGGER.debug("El curso ya ya existe");
    	}    	
    	        
        model.clear();
                
        return "redirect:/courses/";
    }
    
      
    @RequestMapping(value = "course", params={"cancel"}, method = RequestMethod.POST)
    public String goBack(@ModelAttribute Course course, Model model){
    	    	  	
    	LOGGER.debug("Rendering POST Cancel COURSE"); 

        return "redirect:/courses/";
    }
    
    @RequestMapping(value="/viewCourse/{id}", method = RequestMethod.GET)
    public String viewCourse(@PathVariable Long id, Model model) {
    	
    	LOGGER.debug("Rendering view for Course:" + id);
    	
        model.addAttribute("pagina", "courses");
        model.addAttribute("course", this.courseRepository.findOne(id));
        return "course-view";
    }
    
    @RequestMapping(value = "/deleteCourse/{id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable Long id, Course course, final ModelMap model){
    	
   	    course = courseRepository.findOne(id);
   	    
   	    LOGGER.debug("Rendering Delete COURSE Name: " + course.getName()); 
    	
       	courseRepository.delete(course);
        model.clear();

        return "redirect:/courses/";
    }
    
    
    @RequestMapping(value="/editCourse/{id}")
    public String updateCourse(@PathVariable Long id, Model model) {
    	LOGGER.debug("Rendering view for editCourse ID:" + id);
    	
        model.addAttribute("pagina", "courses");
        model.addAttribute("nuevocurso", this.courseRepository.findOne(id));
        return "newCourse";
    }
	

}
