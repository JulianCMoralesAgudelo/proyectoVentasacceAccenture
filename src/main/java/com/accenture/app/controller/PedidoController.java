package com.accenture.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.app.dto.FacturaDto;
import com.accenture.app.dto.PedidoDto;
import com.accenture.app.service.iface.IPedidoService;

@RestController
@RequestMapping("/pedido")
@CrossOrigin("*")
public class PedidoController {
	
	@Autowired
	private IPedidoService pedidoService;
	
	@PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public FacturaDto guardar(@RequestBody @Valid PedidoDto pedido) throws Exception{
		return pedidoService.guardarPedido(pedido);
	}
	
	
	@PutMapping(value = "/edit/{id}")
	public String editar(@RequestBody PedidoDto pedido,
			@PathVariable("id") Long id) {
		return pedidoService.editarFactura(pedido, id);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		return pedidoService.delete(id);
	}
	
}
