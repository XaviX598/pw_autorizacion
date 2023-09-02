package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.to.ProductoTO;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;

	private ProductoTO convertirATo(Producto producto) {
		ProductoTO prod = new ProductoTO();
		prod.setNombre(producto.getNombre());
		prod.setPrecio(producto.getPrecio());
		prod.setCategoria(producto.getCategoria());
		prod.setCodigoBarras(producto.getCodigoBarras());
		prod.setStock(producto.getStock());
		return prod;
	}

	private Producto convertir(ProductoTO producto) {
		Producto prod = new Producto();
		prod.setNombre(producto.getNombre());
		prod.setPrecio(producto.getPrecio());
		prod.setCategoria(producto.getCategoria());
		prod.setCodigoBarras(producto.getCodigoBarras());
		prod.setStock(producto.getStock());
		return prod;
	}

	@Override
	public List<ProductoTO> consultarTodosTO() {
		// TODO Auto-generated method stub
		List<Producto> lista = this.iProductoRepository.buscarTodos();
		List<ProductoTO> listaTO = lista.stream().map(producto -> this.convertirATo(producto))
				.collect(Collectors.toList());
		return listaTO;
	}

	@Override
	public void ingresoProducto(Producto p) {
		// TODO Auto-generated method stub
		Producto prod = null;
		
		try {
			prod= this.iProductoRepository.buscarPorCodigoBarras(p.getCodigoBarras());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if (prod != null) {
			Integer sto = prod.getStock();
			this.actualizarPorCodigo(p.getStock()+sto, p.getCodigoBarras());
			System.out.println("si encontro");
		} else {
			this.iProductoRepository.ingresarProducto(p);
			System.out.println("ni encontro");
		}
	}

	@Override
	public ProductoTO buscarPorCodigo(String codigoBarras) {
		// TODO Auto-generated method stub
		Producto p = this.iProductoRepository.buscarPorCodigoBarras(codigoBarras);
		return this.convertirATo(p);
	}

	@Override
	public void actualizarPorCodigo(Integer stock, String codigoBarras) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizarStock(stock, codigoBarras);
	}

	@Override
	public ProductoTO buscarDisponibilidad(String codigo, Integer cantidad) {
		// TODO Auto-generated method stub
		ProductoTO p = this.buscarPorCodigo(codigo);
		Producto prod = this.convertir(p);
		if (prod != null && prod.getStock() >= cantidad) {
			prod.setStock(prod.getStock() - cantidad);
			this.actualizarPorCodigo(prod.getStock(), codigo);
			return new ProductoTO(prod.getCodigoBarras(), prod.getNombre(), prod.getCategoria(), cantidad,
					prod.getPrecio());
		} else {
			return new ProductoTO();
		}
	}

}
