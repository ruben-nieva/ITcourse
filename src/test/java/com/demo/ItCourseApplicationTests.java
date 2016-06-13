package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.demo.entity.Course;
import com.demo.repository.CourseRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ItCourseApplication.class)
@WebAppConfiguration
public class ItCourseApplicationTests {

	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void findByNameTest() {
		
		Course course1 = new Course("Algebra", "Sample course text1");
		Course course2 = new Course("Fisica", "Sample course text2");
		Course course3 = new Course("Estadistica", "Sample course text3");
		Course course4 = new Course("Paradigmas I", "Sample course text4");
		Course course5 = new Course("Geometria", "Sample course text5");

		courseRepository.save(course1);
		courseRepository.save(course2);
		courseRepository.save(course3);
		courseRepository.save(course4);
		courseRepository.save(course5);
		
		System.out.println(courseRepository.findByName("Algebra"));
		
	}

}
