package com.webapp.edu.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.edu.exceptions.NotFoundException;
import com.webapp.edu.models.TipoDocumento;
import com.webapp.edu.repository.TipoDocumentoRepository;
import com.webapp.edu.service.TipoDocumentoService;

@Service
public class TipoDocumentoImpl implements TipoDocumentoService{

	@Autowired
	TipoDocumentoRepository repository;

	@Override
	public List<TipoDocumento> getAllTipoDocumento() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public TipoDocumento saveTipoDocumento(TipoDocumento tipoDocumento) {
		// TODO Auto-generated method stub
		return repository.save(tipoDocumento);
	}

	@Override
	public void deleteTipoDocumento(int idTipoDocumento) {
		// TODO Auto-generated method stub
		TipoDocumento tipoDocumento = findByTipoDocumento(idTipoDocumento);
		repository.delete(tipoDocumento);
	}

	@Override
	public TipoDocumento updateTipoDocumento(int idTipoDocumento) {
		// TODO Auto-generated method stub
		TipoDocumento tipoDocumento = findByTipoDocumento(idTipoDocumento);

		TipoDocumento newTipoDocumento = new TipoDocumento();
		newTipoDocumento.setCodigo(tipoDocumento.getCodigo());
		newTipoDocumento.setDescripcion(tipoDocumento.getDescripcion());
		newTipoDocumento.setEstado(tipoDocumento.getEstado());
		newTipoDocumento.setNombre(tipoDocumento.getNombre());
		
		return repository.save(newTipoDocumento);
	}

	@Override
	public TipoDocumento findByTipoDocumento(int idTipoDocumento) {
		// TODO Auto-generated method stub
		return repository.findById(idTipoDocumento).orElseThrow(
				() -> new NotFoundException("Ensayo id (" + idTipoDocumento + ") no se encuentra en la base de datos"));
	}
}
