package com.webapp.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.edu.models.Entidad;
import com.webapp.edu.service.EntidadService;

@RestController
@RequestMapping("/api/entidad")
public class EntidadController {
	
	 @Autowired
	 private EntidadService service;
	 
	 @GetMapping
	 public List<Entidad> mostrarEntidades(){
		 return service.getAllEntidades();
	 } 
	 
	 @GetMapping("/{id}")
	 public Entidad findEntidad(@PathVariable("id") int idEntidad){
		 return service.findByIdEntidad(idEntidad);
	 } 
	 
	 @PostMapping
	 public Entidad saveEntidad(@RequestBody Entidad entidad){
		 return service.saveEntidad(entidad);
	 } 
	 
	 @PutMapping
	 public Entidad updateEntidad(@PathVariable("id") int idEntidad){
		 return service.updateEntidad(idEntidad);
	 } 
	 
	 @DeleteMapping("/{id}")
	 public void deleteEntidad(@PathVariable("id") int idEntidad){
		 service.deleteEntidad(idEntidad);
	 } 
}
