package com.accenture.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.app.dto.PedidoDto;
import com.accenture.app.dto.ProductoDto;
import com.accenture.app.service.iface.IProductoService;


@RestController
@RequestMapping("/productos")
@CrossOrigin("*")
public class ProductoController {
	
	@Autowired
	private IProductoService productService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProductoDto> getAll(){
		// TODO: set ClientDto
		return productService.getAll();
	}
	
	/*
	@PutMapping(value = "/edit/{id}")
	public String editar(@RequestBody ProductoDto producto,
			@PathVariable("id") Long id) {
		return productService.editarProducto(producto, id);
	}*/
	

}
