package com.cibertec.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "boleta_has_producto")
public class BoletaHasProducto {

	@EmbeddedId
	private BoletaHasProductoPK boletaHasProductoPK;

	@Column(precision = 22)
	private double precio;

	@Column(length = 10)
	private int cantidad;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(optional = false)
	@JoinColumn(name = "idboleta", nullable = false, insertable = false, updatable = false)
	private Boleta boleta;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(optional = false)
	@JoinColumn(name = "idproducto", nullable = false, insertable = false, updatable = false)
	private Producto producto;

}
