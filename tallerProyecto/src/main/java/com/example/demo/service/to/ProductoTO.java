package com.example.demo.service.to;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

public class ProductoTO extends RepresentationModel<ProductoTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoBarras;
	private String nombre;
	private String categoria;
	private Integer stock;
	private BigDecimal precio;

	public ProductoTO(String codigoBarras, String nombre, String categoria, Integer stock, BigDecimal precio) {
		super();
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.categoria = categoria;
		this.stock = stock;
		this.precio = precio;
	}

	public ProductoTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	// set y get

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
