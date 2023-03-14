package com.webapp.edu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.edu.exceptions.NotFoundException;
import com.webapp.edu.models.TipoContribuyente;
import com.webapp.edu.repository.TipoContribuyenteRepository;
import com.webapp.edu.service.TipoContribuyenteService;

@Service
public class TipoContribuyenteImpl implements TipoContribuyenteService {

	@Autowired
	TipoContribuyenteRepository repository;

	@Override
	public List<TipoContribuyente> getAllTipoContribuyente() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public TipoContribuyente findByTipoContribuyente(int idTipoCont) {
		// TODO Auto-generated method stub
		return repository.findById(idTipoCont).orElseThrow(
				() -> new NotFoundException("Ensayo id (" + idTipoCont + ") no se encuentra en la base de datos"));
	}
	
	@Override
	public TipoContribuyente saveTipoContribuyente(TipoContribuyente tipoContribuyente) {
		// TODO Auto-generated method stub
		return repository.save(tipoContribuyente);
	}

	@Override
	public void deleteTipoContribuyente(int idTipoCont) {
		// TODO Auto-generated method stub
		TipoContribuyente tipoContribuyente = findByTipoContribuyente(idTipoCont);
		repository.delete(tipoContribuyente);
		
	}

	@Override
	public TipoContribuyente updateTipoContribuyente(int idTipoCont) {
		// TODO Auto-generated method stub
		TipoContribuyente tipoContribuyente = findByTipoContribuyente(idTipoCont);
		
		TipoContribuyente newTipoContribuyente = new TipoContribuyente();
		newTipoContribuyente.setNombre(tipoContribuyente.getNombre());
		newTipoContribuyente.setEstado(tipoContribuyente.getEstado());
		
		return repository.save(newTipoContribuyente);
	}
}
