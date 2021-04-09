package com.accenture.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.app.model.ProductoPedido;

public interface IProductoPedidoRepository extends JpaRepository<ProductoPedido, Long>{

}
