package com.demo.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

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
	
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 private Date startDate;
	 
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 private Date endDate;
	
	public Course(){}
	
	
	public Course(Long id, String name, String description){	
		this.idCourse = id;
		this.name=name;
		this.description=description;
	}
	
	public Course(Long id, String name, String description, Date startDate, Date endDate){	
		this.idCourse = id;
		this.name=name;
		this.description=description;
		this.startDate=startDate;
		this.endDate=endDate;
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


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
	

}
