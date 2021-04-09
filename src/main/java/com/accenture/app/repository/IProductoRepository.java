package com.accenture.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.app.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{
	public Producto getOne(Long codigo);
}
