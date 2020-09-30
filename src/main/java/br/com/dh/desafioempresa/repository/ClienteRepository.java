package br.com.dh.desafioempresa.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.desafioempresa.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
