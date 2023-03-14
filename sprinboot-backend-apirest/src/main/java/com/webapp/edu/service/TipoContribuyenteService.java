package com.webapp.edu.service;

import java.util.List;

import com.webapp.edu.models.TipoContribuyente;

public interface TipoContribuyenteService {
	List<TipoContribuyente> getAllTipoContribuyente();
	TipoContribuyente saveTipoContribuyente(TipoContribuyente tipoContribuyente);
	void deleteTipoContribuyente(int idTipoContribuyente);
	TipoContribuyente updateTipoContribuyente(int idTipoContribuyente);
	TipoContribuyente findByTipoContribuyente(int idTipoContribuyente);
}
