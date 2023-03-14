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

import com.webapp.edu.models.TipoDocumento;
import com.webapp.edu.service.TipoDocumentoService;

@RestController
@RequestMapping("/api/tipo_documento")
public class TipoDocumentoController {
	 @Autowired
	 private TipoDocumentoService service;
	 
	 @GetMapping
	 public List<TipoDocumento> mostrarTipoDocumentos(){
		 return service.getAllTipoDocumento();
	 } 
	 
	 @GetMapping("/{id}")
	 public TipoDocumento findTipoDocumento(@PathVariable("id") int idTipoDocumento){
		 return service.findByTipoDocumento(idTipoDocumento);
	 } 
	 
	 @PostMapping
	 public TipoDocumento saveTipoDocumento(@RequestBody TipoDocumento tipoDocumento){
		 return service.saveTipoDocumento(tipoDocumento);
	 } 
	 
	 @PutMapping
	 public TipoDocumento updateTipoDocumento(@PathVariable("id") int idTipoDocumento){
		 return service.updateTipoDocumento(idTipoDocumento);
	 } 
	 
	 @DeleteMapping("/{id}")
	 public void deleteTipoDocumento(@PathVariable("id") int idTipoDocumento){
		 service.deleteTipoDocumento(idTipoDocumento);
	 } 
}
