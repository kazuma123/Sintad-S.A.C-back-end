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
@Table(name="tb_tipo_contribuyente")
@NamedQuery(name="TipoContribuyente.findAll", query="SELECT t FROM TipoContribuyente t")
public class TipoContribuyente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_contribuyente")
	private int idTipoContribuyente;

	private byte estado;

	private String nombre;

	//bi-directional many-to-one association to Entidad
	@OneToMany(mappedBy="tbTipoContribuyente")
	@JsonIgnore
	private List<Entidad> tbEntidads;

	public Entidad addTbEntidad(Entidad tbEntidad) {
		getTbEntidads().add(tbEntidad);
		tbEntidad.setTbTipoContribuyente(this);
		return tbEntidad;
	}

	public Entidad removeTbEntidad(Entidad tbEntidad) {
		getTbEntidads().remove(tbEntidad);
		tbEntidad.setTbTipoContribuyente(null);
		return tbEntidad;
	}

	public TipoContribuyente(byte estado, String nombre) {
		super();
		this.estado = estado;
		this.nombre = nombre;
	}

}