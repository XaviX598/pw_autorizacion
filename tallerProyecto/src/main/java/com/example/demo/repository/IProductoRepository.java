package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface IProductoRepository {
	
	public void ingresarProducto(Producto p);
	
	public Producto buscarPorCodigoBarras(String codigoBarras);
	
	public List<Producto> buscarTodos();

	public void actualizarStock(Integer stock, String codigoBarras);

}
