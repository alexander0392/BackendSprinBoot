package com.ecodeup.api.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodeup.api.apirest.model.Estudiante;

@Service
public class EstudianteService {
	
	@Autowired
	private EstudianteRepository estudianteRepository; 
	
	public void guardar (Estudiante estudiante ) {
		 estudianteRepository.save(estudiante);
		
	}
	
	 public List<Estudiante> odterneTodos(){
		 return estudianteRepository.findAll();
	 }
	 
	 public Estudiante obtenerEstudiante(Integer id) {
		 return estudianteRepository.getOne(id);
	 }
	 
	 public void actualizar(Estudiante estudiante) {
		 estudianteRepository.save(estudiante);
	 }
	 
	 public void eliminar(Integer id) {
		 estudianteRepository.deleteById(id);
	 }

}

