package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.IVentaRepository;
import com.example.demo.repository.modelo.DetalleVenta;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.Venta;
import com.example.demo.security.AuthEntryPointJwt;
import com.example.demo.service.to.ProductoTO;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepository iVentaRepository;

	@Autowired
	private IProductoRepository iProductoRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	@Override
	public void insertar(Integer numeroVenta, String cedula, List<ProductoTO> productos) {

	    List<DetalleVenta> listaDetalles = new ArrayList<>();
	    BigDecimal total = BigDecimal.ZERO;
	    Venta venta = new Venta();
		venta.setNumeroVenta(numeroVenta);
		venta.setCedulaCliente(cedula);
	    for (ProductoTO product : productos) {
	        Producto producto = this.iProductoRepository.buscarPorCodigoBarras(product.getCodigoBarras());

	        
	        if (producto.getStock() >= product.getStock()) {
	            producto.setStock(producto.getStock() - product.getStock());
	            this.iProductoRepository.actualizarStock(producto.getStock(), producto.getCodigoBarras());
	            DetalleVenta detalle = new DetalleVenta();
	            detalle.setCantidad(product.getStock());
	            detalle.setPrecioUnitario(producto.getPrecio());
	            detalle.setSubtotal(producto.getPrecio().multiply(new BigDecimal(product.getStock())));
	            detalle.setVenta(venta);
	            detalle.setProducto(producto);
	            listaDetalles.add(detalle);
	            total = total.add(detalle.getSubtotal());
	        } else {
	            LOG.error("LA CANTIDAD DE PRODUCTOS NO ES SUFICIENTE PARA VENDER LO QUE NECESITA");
	            return; 
	        }
	    }
	    
	    venta.setDetalleVentas(listaDetalles);
	    venta.setTotalVenta(total);

	    this.iVentaRepository.insertar(venta);
	}


	

}
