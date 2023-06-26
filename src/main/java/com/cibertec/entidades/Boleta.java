package com.cibertec.entidades;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "boleta")
public class Boleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, length = 10)
	private int idboleta;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fecha = new Date();

	//@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "idcliente", nullable = false)
	private Cliente cliente;

	//@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "idusuario", nullable = false)
	private Usuario usuario;

	//@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "boleta")
	private List<BoletaHasProducto> detallesBoleta;

}
