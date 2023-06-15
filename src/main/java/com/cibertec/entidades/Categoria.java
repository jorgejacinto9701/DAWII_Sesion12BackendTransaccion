package com.cibertec.entidades;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategoria", unique = true, nullable = false, length = 11)
	private int idCategoria;

	@Column(length = 45)
	private String descripcion;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	private List<Producto> productos;

}
