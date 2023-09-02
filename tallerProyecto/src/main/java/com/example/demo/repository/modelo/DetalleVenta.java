package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalle_venta")
@JsonIgnoreProperties(value = {})
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_venta")
	@SequenceGenerator(name = "seq_detalle_venta", sequenceName = "seq_detalle_venta", allocationSize = 1)
	@Column(name = "deta_id")
	private Integer id;
	@Column(name = "deta_cantidad")
	private Integer Cantidad;
	@Column(name = "precio_unitario")
	private BigDecimal precioUnitario;
	@Column(name = "deta_subtotal")
	private BigDecimal subtotal;
	@ManyToOne
	@JoinColumn(name = "deta_id_producto")
	private Producto producto;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "deta_id_venta")
	private Venta venta;

	// set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}
