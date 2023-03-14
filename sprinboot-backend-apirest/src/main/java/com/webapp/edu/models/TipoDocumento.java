package com.webapp.edu.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_tipo_documento")
@NamedQuery(name="TipoDocumento.findAll", query="SELECT t FROM TipoDocumento t")
public class TipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_documento")
	private int idTipoDocumento;

	private String codigo;

	private String descripcion;

	private byte estado;

	private String nombre;

	
	
	//bi-directional many-to-one association to Entidad
	@OneToMany(mappedBy="tbTipoDocumento")
	@JsonIgnore
	private List<Entidad> tbEntidads;

	public Entidad addTbEntidad(Entidad tbEntidad) {
		getTbEntidads().add(tbEntidad);
		tbEntidad.setTbTipoDocumento(this);

		return tbEntidad;
	}

	public Entidad removeTbEntidad(Entidad tbEntidad) {
		getTbEntidads().remove(tbEntidad);
		tbEntidad.setTbTipoDocumento(null);

		return tbEntidad;
	}

	public TipoDocumento(String codigo, String descripcion, byte estado, String nombre) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.nombre = nombre;
	}

}