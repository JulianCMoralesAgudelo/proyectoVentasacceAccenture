package com.accenture.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.app.model.Pedido;

public interface IPedidoRepository extends JpaRepository<Pedido, Long>{

}
