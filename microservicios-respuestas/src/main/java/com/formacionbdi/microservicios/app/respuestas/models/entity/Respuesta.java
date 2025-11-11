package com.formacionbdi.microservicios.app.respuestas.models.entity;

import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Pregunta;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Document(collection = "respuestas")
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "texto"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Respuesta {
	@Id
	String id;
	
	String texto;

//	 @Transient
	Alumno alumno;
	
	Long alumnoId;
	
//	@Transient
	Pregunta pregunta;
	
	Long preguntaId;
}