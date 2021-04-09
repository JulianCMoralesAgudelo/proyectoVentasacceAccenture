package com.accenture.app.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.app.dto.FacturaDto;
import com.accenture.app.dto.PedidoDto;
import com.accenture.app.dto.ProductoDto;
import com.accenture.app.model.Pedido;
import com.accenture.app.model.Producto;
import com.accenture.app.repository.IPedidoRepository;
import com.accenture.app.repository.IProductoRepository;
import com.accenture.app.service.iface.IPedidoService;

@Service
public class PedidoService implements IPedidoService{
	private static final Double DOMICILIO = 1000.0;
	private static final Double IVA = 0.19;
	private static final Double TOPE_1 = 70000.0;
	private static final Double TOPE_2 = 100000.0;
	private static final Integer TIEMPO_PLAZO = 300;
	private static final Integer TIEMPO_PLAZO_2 = 720;
	
	@Autowired
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Override
	public FacturaDto guardarPedido(PedidoDto pedido) throws Exception{
		FacturaDto factura = new FacturaDto();
		List<ProductoDto> productos = new ArrayList<>();
		Double iva = 0.0;
		Double domicilio = 0.0;
		Double total = pedido.getProductoPedido()
				.stream()
				.mapToDouble(p -> {
					Long codigo = p.getProducto().getCodigo();
					Producto prod = productoRepository.getOne(codigo);
					Double precioUnitario = prod.getPrecioUnitario();
					if(prod.getStock() < p.getCantidad()) {
						throw new RuntimeException("No hay stock");
					}					
					ProductoDto pDto = new ProductoDto();
					pDto.setCodigo(prod.getCodigo());
					pDto.setNombre(prod.getNombre());
					productos.add(pDto);
					return p.getCantidad()*precioUnitario;
				})
				.sum();
		if(total > TOPE_1) {
			iva = total;
			domicilio = DOMICILIO;
		}if(total  > TOPE_2) {
			iva = 0.0;
			domicilio = 0.0;
		}
		factura.setCliente(pedido.getCliente());
		factura.setDomicilio(domicilio);
		factura.setIva(total*iva);
		factura.setTotal(total + (total*iva) + domicilio);
		factura.setSubTotal(total);
		factura.setProductos(productos);
		// TODO: Guardar el pedido
		//pedidoRepository.save(pedido);
		return factura;
	}

	@Override
	public FacturaDto generarFactura(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editarFactura(PedidoDto pedido, Long id) {
		Pedido ped = pedidoRepository.getOne(id);
		Double iva = 0.0;
		Double domicilio = 0.0;
		List<ProductoDto> productos = new ArrayList<>();
		if(ped != null) {
	        LocalDateTime hoy = LocalDateTime.now();
	        LocalDateTime tiempoCompra = ped.getFecha();
	        long time = tiempoCompra.until(hoy, ChronoUnit.MINUTES);
			if(time > TIEMPO_PLAZO) {
				return "No se puede editar por tiempo";
			}
			Double total = pedido.getProductoPedido()
					.stream()
					.mapToDouble(p -> {
						Long codigo = p.getProducto().getCodigo();
						Producto prod = productoRepository.getOne(codigo);
						Double precioUnitario = prod.getPrecioUnitario();
						if(prod.getStock() < p.getCantidad()) {
							throw new RuntimeException("No hay stock");
						}
						ProductoDto pDto = new ProductoDto();
						pDto.setCodigo(prod.getCodigo());
						pDto.setNombre(prod.getNombre());
						productos.add(pDto);
						return p.getCantidad()*precioUnitario;
					})
					.sum();
			if(total < ped.getTotal()){
				return "No se puede editar por precio!";
			}
			if(ped.getTotal() == TOPE_1 && total > TOPE_2) {
				total = total - DOMICILIO;
			}
			// seteo variables pedido modificado
			//----
			//pedidoRepository.save(ped);
		}
		return "Editado!";
		
	}

	@Override
	public String delete(Long id) {
		Optional<Pedido> pedidoOpc = pedidoRepository.findById(id);
		if(pedidoOpc.isPresent()) {
	        LocalDateTime hoy = LocalDateTime.now();
	        LocalDateTime tiempoCompra = pedidoOpc.get().getFecha();
	        long time = tiempoCompra.until(hoy, ChronoUnit.MINUTES);
			if(time > TIEMPO_PLAZO_2) {
				return "No se puede eliminar por tiempo";
			}
		}
		
		return "OK!";
	}


	
}
