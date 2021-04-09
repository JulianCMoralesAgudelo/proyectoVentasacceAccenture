package com.accenture.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.app.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, String>{
	
}
