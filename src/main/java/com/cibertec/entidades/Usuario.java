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
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario", unique = true, nullable = false, length = 10)
	private int idUsuario;

	@Column(length = 45)
	private String nombre;

	@Column(length = 45)
	private String login;

	@Column(length = 45)
	private String clave;

	@Column(length = 45)
	private String correo;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Boleta> boletas;

}
