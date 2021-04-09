package com.accenture.app.dto;

public class ProductoPedidoDto {
	private Integer Id;
	private PedidoDto pedido;
	private ProductoDto producto;
	private Integer cantidad;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}
	/**
	 * @return the pedido
	 */
	public PedidoDto getPedido() {
		return pedido;
	}
	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(PedidoDto pedido) {
		this.pedido = pedido;
	}
	/**
	 * @return the producto
	 */
	public ProductoDto getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
