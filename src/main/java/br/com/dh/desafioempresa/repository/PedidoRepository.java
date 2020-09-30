package br.com.dh.desafioempresa.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.desafioempresa.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

}
