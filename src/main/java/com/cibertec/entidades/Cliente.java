package com.cibertec.entidades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcliente", unique = true, nullable = false, length = 10)
	private int idCliente;

	@Column(length = 45)
	private String nombre;

	@Column(length = 45)
	private String apellido;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Boleta> boletas;

}
