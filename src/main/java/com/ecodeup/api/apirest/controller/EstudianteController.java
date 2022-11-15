package com.ecodeup.api.apirest.controller;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecodeup.api.apirest.model.Estudiante;
@RestController
public class EstudianteController {
	@Autowired
	private EstudianteService estudianteServices; 
	@GetMapping("api/estudiantes")
	public List<Estudiante> obtenerEstudiantes() {
		List<Estudiante> listastudiantes= new ArrayList<>();
		Estudiante e = new Estudiante();
		
		e.setId(1);
		e.setNombres("Elivar");
		e.setApellidos("Largo");
		e.setEmail("elargor@gmail.com");
		e.setNota(5D);
		
		Estudiante e1 = new Estudiante();
		
		e1.setId(1);
		e1.setNombres("Erick");
		e1.setApellidos("Martinez");
		e1.setEmail("eam@gmail.com");
		e1.setNota(5D);
		
		listastudiantes.add(e);
		listastudiantes.add(e1);
		
		return listastudiantes;
	}
	@PostMapping("api/estudiantes")
	public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante) {
		System.out.println(estudiante);
		estudianteServices.guardar(estudiante);
		return estudiante;
	}
	@GetMapping("api/mostrar")
	public ResponseEntity <List<Estudiante>> findAll(){
		return new ResponseEntity<>(estudianteServices.odterneTodos(), HttpStatus.OK);
	}
	@GetMapping("api/estudiante/{id}")
	public Estudiante obtenerEstudiante(@PathVariable("id") Integer id) {
		return estudianteServices.obtenerEstudiante(id);
	}
	
	@PutMapping("api/estudiantes")
	public void actualizarEstudiante(@RequestBody Estudiante estudiante) {
		 estudianteServices.actualizar(estudiante);
	 }
	
	@DeleteMapping("api/estudiantes/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		estudianteServices.eliminar(id);
	}

}
