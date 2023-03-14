package com.webapp.edu;

import java.util.Optional;

import com.webapp.edu.models.Entidad;
import com.webapp.edu.models.TipoContribuyente;
import com.webapp.edu.models.TipoDocumento;

public class Datos {
	public static byte estado = 1;
	public static final TipoDocumento TIPO_DOCUMENTO_001 = new TipoDocumento("145789","Prueba Descripcion",estado,"Descripcion");
	public static final TipoContribuyente TIPO_CONTRIBUYENTE_001 = new TipoContribuyente(estado, "Interbank");
	public static final Entidad ENTIDAD_001 = new Entidad("Esta es una nuvea direccion",estado,"Adidas","1478","SQL","123", TIPO_CONTRIBUYENTE_001, TIPO_DOCUMENTO_001);
	
	public static Optional<TipoDocumento> crearTipoDocumento001() {
		return Optional.of(new TipoDocumento("145789","Prueba Descripcion",estado,"Descripcion"));
	}
	
	public static Optional<TipoContribuyente> crearTipoContribuyente001() {
		return Optional.of(new TipoContribuyente(estado, "Interbank"));
	}
	public static Optional<Entidad> crearEntidad001() {
		return Optional.of(new Entidad("Esta es una nuvea direccion",estado,
				"Adidas","1478","SQL","123", 
				TIPO_CONTRIBUYENTE_001, TIPO_DOCUMENTO_001));
	}
	
	public static Optional<Entidad> crearEntidad002() {
		return Optional.of(new Entidad("Otra direccion",estado,
				"Nike","26458","Mysql","78956", 
				TIPO_CONTRIBUYENTE_001, TIPO_DOCUMENTO_001));
	}
}
