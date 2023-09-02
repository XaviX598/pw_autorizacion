package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IVentaService;
import com.example.demo.service.to.VentaTO;

@RestController
@RequestMapping("/ventas")
@CrossOrigin
public class VentaControllerRestFul {

	@Autowired
	private IVentaService iVentaService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public void registrarVenta(@RequestBody VentaTO venta) {
		this.iVentaService.insertar(venta.getNumeroVenta(), venta.getCedulaCliente(), venta.getProductos());
	}

}
