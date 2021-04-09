package com.accenture.app.service.iface;

import java.util.List;

import com.accenture.app.dto.ProductoDto;

public interface IProductoService {

	
public List<ProductoDto> getAll();
	
	public ProductoDto getByCodigo(Long codigo);
	
	public String editarFactura(ProductoDto producto, Long id);
	

}
