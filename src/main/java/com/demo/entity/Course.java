package com.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="course")
public class Course extends BaseEntity<Long> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCourse;
	
	@Column(name="name", length=100, nullable=false, unique=true)
	private String name;
	
	@OneToMany(mappedBy = "mycourse", cascade = CascadeType.ALL)
    private List<Alumno> alumnos;
	
	@Column(name="description", length=255)
	@Type(type="text")
	private String description;
	
	public Course(){}
	
	
	public Course(String name, String description){		
		this.name=name;
		this.description=description;
	}
	
	@Override
	public Long getIdCourse() {
		return idCourse;
	}


	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return ("Course id=" + idCourse + ", name=" + name + ", description=" + description);
	}	
	

}
