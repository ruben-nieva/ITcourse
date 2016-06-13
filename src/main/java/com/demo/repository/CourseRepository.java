package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	public Course findByName(String name);
    
//	Iterable<Course> listAllCourses();

}
