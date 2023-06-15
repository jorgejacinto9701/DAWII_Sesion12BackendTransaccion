package com.cibertec.entidades;

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
@Table(name = "boleta_has_boleta")
public class BoletaHasProducto {

	@EmbeddedId
	private BoletaHasProductoPK productoHasBoletaPK;

	@Column(precision = 22)
	private double precio;

	@Column(length = 10)
	private int cantidad;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idboleta", nullable = false, insertable = false, updatable = false)
	private Boleta boleta;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idproducto", nullable = false, insertable = false, updatable = false)
	private Producto producto;

}
