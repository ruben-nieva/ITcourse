package com.demo;
import com.demo.entity.*;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.repository.AlumnoRepository;
import com.demo.repository.CourseRepository;

@SpringBootApplication
public class ItCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItCourseApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner runner(CourseRepository courseRepository, AlumnoRepository alumnoRepository){
		return new CommandLineRunner() {
			@Override			
			public void run(String... strings) throws Exception {
				
				Course course1 = new Course(1L, "Algebra", "Sample course text1");
				Course course2 = new Course(2L, "Fisica", "Sample course text2");
				Course course3 = new Course(3L, "Estadistica", "Sample course text3");
				
				courseRepository.save(course1);
				courseRepository.save(course2);
				courseRepository.save(course3);
				
			}
		};
	
	}
}
