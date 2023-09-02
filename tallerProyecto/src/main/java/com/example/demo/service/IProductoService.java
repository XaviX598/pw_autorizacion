package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.to.ProductoTO;

public interface IProductoService {

	public void ingresoProducto(Producto p);

	public ProductoTO buscarPorCodigo(String codigoBarras);

	public List<ProductoTO> consultarTodosTO();

	public void actualizarPorCodigo(Integer stock, String codigoBarras);

	public ProductoTO buscarDisponibilidad(String codigo, Integer cantidad);

}
