package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHOme(){		
		
		LOGGER.debug("Redering home view");
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){		
		
		LOGGER.debug("Redering login page");
		return "login";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String addNewStudent(){		
		
		LOGGER.debug("Redering addStudent");
		return "newAlumno";
	}

}
