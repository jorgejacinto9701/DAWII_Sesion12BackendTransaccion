package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entidades.Boleta;
import com.cibertec.entidades.Cliente;
import com.cibertec.entidades.Producto;
import com.cibertec.service.BoletaService;
import com.cibertec.service.ClienteService;
import com.cibertec.service.ProductoService;

@RestController
@RequestMapping("/rest/boleta")
@CrossOrigin(origins = "http://localhost:4200")
public class BoletaController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private BoletaService boletaService;

	@PostMapping("/registraBoleta")
	@ResponseBody
	public ResponseEntity<?> registraBoleta(@RequestBody  Boleta objBoleta) {
		
		HashMap<String, Object> salida = new HashMap<String, Object>();
		Boleta objBoletaSalida = boletaService.insertaBoleta(objBoleta);
		if (objBoletaSalida != null) {
			salida.put("mensaje", "Se registró la boleta " + objBoletaSalida.getIdboleta());
			salida.put("data", objBoletaSalida);
		}else {
			salida.put("mensaje", "No se registró la boleta, consulte al administardor");
		}
		return ResponseEntity.ok(salida); 
	}
	
	@GetMapping("/listaBoletas")
	public ResponseEntity<?> lista() {
		List<Boleta> lstBoletas = boletaService.listaBoleta();
		return ResponseEntity.ok(lstBoletas); 
	}

	@GetMapping("/listaProducto")
	public ResponseEntity<?> listaProducto(
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "size", defaultValue = "5", required = false) int size) {
		Pageable paginacion = PageRequest.of(page, size);
		List<Producto> lista = productoService.listaproducto("%", paginacion);
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listaProducto/{filtro}")
	public ResponseEntity<?> listaProducto(@PathVariable("filtro") String filtro,
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "size", defaultValue = "5", required = false) int size) {
		Pageable paginacion = PageRequest.of(page, size);
		List<Producto> lista = productoService.listaproducto(filtro + "%", paginacion);
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listaCliente")
	public ResponseEntity<?> listaCliente(
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "size", defaultValue = "5", required = false) int size) {
		Pageable paginacion = PageRequest.of(page, size);
		List<Cliente> lista = clienteService.listaCliente("%", paginacion);
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listaCliente/{filtro}")
	public ResponseEntity<?> listaCliente(@PathVariable("filtro") String filtro,
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "size", defaultValue = "5", required = false) int size) {
		Pageable paginacion = PageRequest.of(page, size);
		List<Cliente> lista = clienteService.listaCliente(filtro + "%", paginacion);
		return ResponseEntity.ok(lista);
	}
}
