package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Alumno;


public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
