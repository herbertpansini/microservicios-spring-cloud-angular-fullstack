package com.formacionbdi.microservicios.app.examenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
	
	List<Examen> findByNombreContainingIgnoreCase(String nombre);
}