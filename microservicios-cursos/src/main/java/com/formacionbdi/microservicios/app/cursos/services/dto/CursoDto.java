package com.formacionbdi.microservicios.app.cursos.services.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;
import com.formacionbdi.microservicios.commons.examenes.services.dto.ExamenDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class CursoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Long id;
	
	@NotEmpty
	@Size(min = 4, max = 30)
	String nombre;
	
	Date createdAt;
	Set<AlumnoDto> alumnos = new HashSet<>();
	Set<ExamenDto> examenes = new HashSet<>();
	Set<CursoAlumnoDto> cursosAlumnos = new HashSet<>();
		
	public void addAlumno(AlumnoDto alumno) {
		this.alumnos.add(alumno);
	}
	
	public void removeAlumno(AlumnoDto alumno) {
		this.alumnos.remove(alumno);
	}
	
	public void addExamen(ExamenDto examen) {
		this.examenes.add(examen);
	}
	
	public void removeExamen(ExamenDto examen) {
		this.examenes.remove(examen);
	}
	
	public void addCursoAlumno(CursoAlumnoDto cursoAlumno) {
		this.cursosAlumnos.add(cursoAlumno);
	}
	
	public void removeCursoAlumno(CursoAlumnoDto cursoAlumno) {
		this.cursosAlumnos.remove(cursoAlumno);
	}
}