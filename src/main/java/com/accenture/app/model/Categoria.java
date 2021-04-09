package com.accenture.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="categoria")
	private List<Producto> productos;

	public Categoria() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
