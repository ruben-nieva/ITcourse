package com.demo;

import java.util.Date;

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
		
		Course course1 = new Course(1L, "Algebra", "Sample course text1");
		Course course2 = new Course(2L, "Fisica", "Sample course text2");
		Course course3 = new Course(3L, "Estadistica", "Sample course text3");
		Course course4 = new Course(4L, "Paradigmas I", "Sample course text4");
		Course course5 = new Course(5L, "Geometria", "Sample course text5");

		courseRepository.save(course1);
		courseRepository.save(course2);
		courseRepository.save(course3);
		courseRepository.save(course4);
		courseRepository.save(course5);
		
		System.out.println(courseRepository.findByName("Algebra"));
		
	}

}
