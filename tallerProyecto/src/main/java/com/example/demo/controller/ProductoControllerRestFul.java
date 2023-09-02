package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.IProductoService;
import com.example.demo.service.to.ProductoTO;

@RestController
@RequestMapping("/productos")
@CrossOrigin
public class ProductoControllerRestFul {

	@Autowired
	private IProductoService iProductoService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public void guardar(@RequestBody Producto producto) {
		this.iProductoService.ingresoProducto(producto);
	}

	@PostMapping(path = "/{codigo}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoTO> verificarDisponibilidad(@PathVariable String codigo,
			@RequestBody ProductoTO producto) {

		ProductoTO prod = this.iProductoService.buscarDisponibilidad(codigo, producto.getStock());

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje", "No se encuentra disponible");

		if (prod.getCodigoBarras() == null) {
			return new ResponseEntity<>(prod, cabeceras, 200);
		} else {
			return new ResponseEntity<>(prod, null, 200);
		}
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoTO>> consultarTodosHATEOAS() {
		List<ProductoTO> lista = this.iProductoService.consultarTodosTO();
		return new ResponseEntity<>(lista, null, 200);

	}

}
