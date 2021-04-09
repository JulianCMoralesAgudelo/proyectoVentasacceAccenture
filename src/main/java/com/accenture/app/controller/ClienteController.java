package com.accenture.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.app.dto.ClienteDto;
import com.accenture.app.service.iface.IClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ClienteDto> getAll(){
		// TODO: set ClientDto
		return clienteService.getAll();
	}
	
	
	
	
	
}
