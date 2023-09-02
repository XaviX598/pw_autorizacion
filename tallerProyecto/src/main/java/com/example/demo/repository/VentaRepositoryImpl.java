package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Venta;

@Repository
@Transactional
public class VentaRepositoryImpl implements IVentaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Venta v) {
		// TODO Auto-generated method stub
		this.entityManager.persist(v);
	}

}
