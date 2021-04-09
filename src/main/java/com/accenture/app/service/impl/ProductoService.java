package com.accenture.app.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.app.dto.ProductoDto;
import com.accenture.app.model.Producto;
import com.accenture.app.repository.IProductoRepository;
import com.accenture.app.service.iface.IProductoService;

@Service
public class ProductoService implements IProductoService{
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Override
	public List<ProductoDto> getAll() {
		// TODO: change to ClientDto & add Exceptions
		List<Producto> productos = productoRepository.findAll();
		List<ProductoDto> productosDto = new ArrayList<>();
		productos.forEach(p -> {
			ProductoDto pd = new ProductoDto();
			pd.setCodigo(p.getCodigo());
			pd.setNombre(p.getNombre());
			pd.setDescripcion(p.getDescripcion());
			pd.setPrecioUnitario(p.getPrecioUnitario());
			pd.setStock(p.getStock());
			//pd.setCategoria(p.getCategoria());
			productosDto.add(pd);
		});
		return productosDto;
	}


	@Override
	public ProductoDto getByCodigo(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editarFactura(ProductoDto producto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
