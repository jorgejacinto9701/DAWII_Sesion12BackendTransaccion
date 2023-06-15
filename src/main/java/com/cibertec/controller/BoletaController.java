package com.cibertec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cibertec.entidades.Boleta;
import com.cibertec.entidades.Cliente;
import com.cibertec.entidades.Mensaje;
import com.cibertec.entidades.Producto;
import com.cibertec.entidades.BoletaHasProducto;
import com.cibertec.entidades.BoletaHasProductoPK;
import com.cibertec.entidades.Seleccion;
import com.cibertec.entidades.Usuario;
import com.cibertec.service.BoletaService;
import com.cibertec.service.ClienteService;
import com.cibertec.service.ProductoService;

@Controller
public class BoletaController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private BoletaService boletaService;
	
	
	
	
}
