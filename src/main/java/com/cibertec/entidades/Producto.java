package com.cibertec.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto", unique = true, nullable = false, length = 10)
	private int idProducto;

	@Column(length = 45)
	private String nombre;

	@Column(precision = 22)
	private double precio;

	@Column(length = 10)
	private int stock;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idcategoria", nullable = false)
	private Categoria categoria;

}
