package com.example.demo.service.to;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class VentaTO extends RepresentationModel<VentaTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer numeroVenta;
	private String cedulaCliente;
	private List<ProductoTO> productos;

	// set y get

	public Integer getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(Integer numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public List<ProductoTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoTO> productos) {
		this.productos = productos;
	}

}
