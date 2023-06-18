package com.cibertec.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cibertec.entidades.Cliente;

public interface ClienteService {

	public abstract List<Cliente> listaCliente(String filtro, Pageable ageable) ;
	
}
