package com.accenture.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.app.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long>{

}
