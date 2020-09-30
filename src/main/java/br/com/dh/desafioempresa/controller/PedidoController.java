package br.com.dh.desafioempresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.desafioempresa.model.Pedido;
import br.com.dh.desafioempresa.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoRepository repository;
	
	@PostMapping()
	public Pedido cadastrarPedido(@RequestBody Pedido pedido) {
		return repository.save(pedido);
	}
	
	@GetMapping()
	public Iterable<Pedido> getPedidos() {
		return repository.findAll();
	}

}

	