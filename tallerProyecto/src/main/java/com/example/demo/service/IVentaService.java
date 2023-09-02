package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.ProductoTO;

public interface IVentaService {

	public void insertar(Integer numeroVenta, String cedula, List<ProductoTO> productos);
	

}
