package com.accenture.app.service.iface;

import com.accenture.app.dto.FacturaDto;
import com.accenture.app.dto.PedidoDto;
import com.accenture.app.model.Pedido;

public interface IPedidoService {
	
	public FacturaDto guardarPedido(PedidoDto pedido) throws Exception;
	
	public FacturaDto generarFactura(Pedido pedido);
	
	public String editarFactura(PedidoDto pedido, Long id);
	
	public String delete(Long id);
}
