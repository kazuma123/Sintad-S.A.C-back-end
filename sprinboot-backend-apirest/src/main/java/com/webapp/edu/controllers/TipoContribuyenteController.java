package com.webapp.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.edu.models.TipoContribuyente;
import com.webapp.edu.service.TipoContribuyenteService;

@RestController
@RequestMapping("/api/tipo_contribuyente")
public class TipoContribuyenteController {
	
	 @Autowired
	 private TipoContribuyenteService service;
	 
	 @GetMapping
	 public List<TipoContribuyente> mostrarTipoContribuyentes(){
		 return service.getAllTipoContribuyente();
	 } 
	 
	 @GetMapping("/{id}")
	 public TipoContribuyente findTipoContribuyente(@PathVariable("id") int idTipoContribuyente){
		 return service.findByTipoContribuyente(idTipoContribuyente);
	 } 
	 
	 @PostMapping
	 public TipoContribuyente saveTipoContribuyente(@RequestBody TipoContribuyente idTipoContribuyente){
		 return service.saveTipoContribuyente(idTipoContribuyente);
	 } 
	 
	 @PutMapping
	 public TipoContribuyente updateEntidad(@PathVariable("id") int idTipoContribuyente){
		 return service.updateTipoContribuyente(idTipoContribuyente);
	 } 
	 
	 @DeleteMapping("/{id}")
	 public void deleteTipoContribuyente(@PathVariable("id") int idTipoContribuyente){
		 service.deleteTipoContribuyente(idTipoContribuyente);
	 } 
}
