package com.accenture.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.app.dto.ClienteDto;
import com.accenture.app.model.Cliente;
import com.accenture.app.repository.IClienteRepository;
import com.accenture.app.service.iface.IClienteService;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	public List<ClienteDto> getAll() {
		// TODO: change to ClientDto & add Exceptions
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDto> clientesDto = new ArrayList<>();
		clientes.forEach(c -> {
			ClienteDto cl = new ClienteDto();
			cl.setCedula(c.getCedula());
			cl.setNombre(c.getNombre());
			cl.setApellido(c.getApellido());
			cl.setDireccion(c.getDireccion());
			cl.setEmail(c.getEmail());
			clientesDto.add(cl);
		});
		return clientesDto;
	}

	@Override
	public ClienteDto getByCedula(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(ClienteDto clienteDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
