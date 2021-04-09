package com.accenture.app.service.iface;

import java.util.List;

import com.accenture.app.dto.ClienteDto;

public interface IClienteService {
	
	public List<ClienteDto> getAll();
	
	public ClienteDto getByCedula(String cedula);
	
	public void create(ClienteDto clienteDto) throws Exception;
}
