package com.cibertec.service;

import java.util.List;

import com.cibertec.entidades.Cliente;

public interface ClienteService {

	public abstract List<Cliente> listaCliente(String filtro) ;
	
}
