package com.webapp.edu.service;

import java.util.List;

import com.webapp.edu.models.Entidad;

public interface EntidadService {
	List<Entidad> getAllEntidades();
	Entidad saveEntidad(Entidad entidad);
	void deleteEntidad(int idEntidad);
	Entidad updateEntidad(int idEntidad);
	Entidad findByIdEntidad(int idEntidad);
}
