package com.webapp.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.edu.exceptions.NotFoundException;
import com.webapp.edu.models.Entidad;
import com.webapp.edu.repository.EntidadRepository;
import com.webapp.edu.service.EntidadService;

@Service
public class EntidadServiceImpl implements EntidadService {

	@Autowired
	private EntidadRepository repository;

	@Override
	public List<Entidad> getAllEntidades() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Entidad findByIdEntidad(int idEntidad) {
		// TODO Auto-generated method stub
		return repository.findById(idEntidad).orElseThrow(
				() -> new NotFoundException("Ensayo id (" + idEntidad + ") no se encuentra en la base de datos"));
	}

	@Override
	public Entidad saveEntidad(Entidad entidad) {
		// TODO Auto-generated method stub
		return repository.save(entidad);
	}

	@Override
	public void deleteEntidad(int idEntidad) {
		Entidad deleteEntidad = findByIdEntidad(idEntidad);
		
		repository.delete(deleteEntidad);
	}

	@Override
	public Entidad updateEntidad(int idEntidad) {
		Entidad entidadActual = findByIdEntidad(idEntidad);
		
		Entidad newEntidad = new Entidad();
		newEntidad.setDireccion(entidadActual.getDireccion());
		newEntidad.setEstado(entidadActual.getEstado());
		newEntidad.setNombreComercial(entidadActual.getNombreComercial());
		newEntidad.setNroDocumento(entidadActual.getNroDocumento());
		newEntidad.setRazonSocial(entidadActual.getRazonSocial());
		newEntidad.setTbTipoContribuyente(entidadActual.getTbTipoContribuyente());
		newEntidad.setTbTipoDocumento(entidadActual.getTbTipoDocumento());
		newEntidad.setTelefono(entidadActual.getTelefono());
		
		return repository.save(newEntidad);
	}
}
