package br.com.dh.desafioempresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.desafioempresa.model.Cliente;
import br.com.dh.desafioempresa.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository repository;
	
	
	@PostMapping()
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	@GetMapping()
	public Iterable<Cliente> getClientes(){
		return repository.findAll();
	}
}
