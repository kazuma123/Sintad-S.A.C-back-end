package com.webapp.edu.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_entidad")
@NamedQuery(name="Entidad.findAll", query="SELECT e FROM Entidad e")
@Data
public class Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_entidad")
	private int idEntidad;

	private String direccion;

	private byte estado;

	@Column(name="nombre_comercial")
	private String nombreComercial;

	@Column(name="nro_documento")
	private String nroDocumento;

	@Column(name="razon_social")
	private String razonSocial;

	private String telefono;

	//bi-directional many-to-one association to TipoContribuyente
	@ManyToOne
	@JoinColumn(name="id_tipo_contribuyente")
	private TipoContribuyente tbTipoContribuyente;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="id_tipo_documento")
	private TipoDocumento tbTipoDocumento;
	
	
	
	public Entidad(String direccion, byte estado, String nombreComercial, String nroDocumento, String razonSocial,
			String telefono, TipoContribuyente tbTipoContribuyente, TipoDocumento tbTipoDocumento) {
		super();
		this.direccion = direccion;
		this.estado = estado;
		this.nombreComercial = nombreComercial;
		this.nroDocumento = nroDocumento;
		this.razonSocial = razonSocial;
		this.telefono = telefono;
		this.tbTipoContribuyente = tbTipoContribuyente;
		this.tbTipoDocumento = tbTipoDocumento;
	}

}