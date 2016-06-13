package com.demo;


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
				
				/*Course course1 = new Course("Algebra", "Sample course text1");
				Course course2 = new Course("Fisica", "Sample course text2");
				Course course3 = new Course("Estadistica", "Sample course text3");
				Course course4 = new Course("Paradigmas I", "Sample course text4");
				Course course5 = new Course("Geometria", "Sample course text5");

				courseRepository.save(course1);
				courseRepository.save(course2);
				courseRepository.save(course3);
				courseRepository.save(course4);
				courseRepository.save(course5);*/
			}
		};
	
	}
}
