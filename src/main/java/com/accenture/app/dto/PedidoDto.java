package com.accenture.app.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.accenture.app.model.Cliente;

public class PedidoDto {
	private Long id;
	private Cliente cliente;
	private LocalDateTime fecha;
	private List<ProductoPedidoDto> productoPedido; 
	
	public PedidoDto() {
		
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the fecha
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the productoPedido
	 */
	public List<ProductoPedidoDto> getProductoPedido() {
		return productoPedido;
	}

	/**
	 * @param productoPedido the productoPedido to set
	 */
	public void setProductoPedido(List<ProductoPedidoDto> productoPedido) {
		this.productoPedido = productoPedido;
	}
	
}
