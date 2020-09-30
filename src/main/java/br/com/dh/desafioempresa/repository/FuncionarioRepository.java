package br.com.dh.desafioempresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.dh.desafioempresa.model.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

	@Transactional
	@Modifying
	@Query("update Funcionario f set habilitado = false where f.id = :id")
	public void demitirFuncionario(@PathVariable int id);
	
	@Query("Select f from Funcionario f where f.habilitado = true")
	public List<Funcionario> obterFuncionariosAtivos();
	
}
