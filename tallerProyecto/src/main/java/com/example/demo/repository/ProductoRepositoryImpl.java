package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void ingresarProducto(Producto p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
	}

	@Override
	public Producto buscarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :datoCodigo", Producto.class);
		myQuery.setParameter("datoCodigo", codigoBarras);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Producto> buscarTodos() {
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizarStock(Integer stock, String codigoBarras) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("UPDATE Producto p SET p.stock= :datoStock WHERE p.codigoBarras= :datoCondicion");
		myQuery.setParameter("datoStock", stock);
		myQuery.setParameter("datoCondicion", codigoBarras);
		myQuery.executeUpdate();
	}

}
