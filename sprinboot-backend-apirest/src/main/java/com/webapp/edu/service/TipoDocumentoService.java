package com.webapp.edu.service;

import java.util.List;

import com.webapp.edu.models.TipoDocumento;

public interface TipoDocumentoService {
	List<TipoDocumento> getAllTipoDocumento();
	TipoDocumento saveTipoDocumento(TipoDocumento tipoDocumento);
	void deleteTipoDocumento(int idTipoCont);
	TipoDocumento updateTipoDocumento(int idTipoDocumento);
	TipoDocumento findByTipoDocumento(int idTipoDocumento);
}
