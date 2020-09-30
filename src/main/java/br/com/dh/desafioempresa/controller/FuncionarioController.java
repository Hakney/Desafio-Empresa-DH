package br.com.dh.desafioempresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.desafioempresa.model.Funcionario;
import br.com.dh.desafioempresa.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository repository;
	
	
	@GetMapping()
	public List<Funcionario> getFuncionariosAtivos() {
		return repository.obterFuncionariosAtivos();
	}
	
	@GetMapping("/{id}")
	public Optional<Funcionario> getFuncionario(@PathVariable int id) {
		return repository.findById(id);
		 
	}
	
	@PostMapping()
	public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
		return repository.save(funcionario);
	}
	
	@PutMapping("/demitir/{id}")
	public void demitirFuncionario(@PathVariable int id) {
		repository.demitirFuncionario(id);
	}
	
	@PutMapping("/reajustarsalario/{id}")
	public void reajustarSalario(@RequestBody Funcionario dadosFuncionario, @PathVariable int id) throws IllegalAccessException {
		Funcionario funcionarioDB = repository.findById(id).orElseThrow(()-> new IllegalAccessException());
		
		if(dadosFuncionario.getSalario() != funcionarioDB.getSalario()) {
			funcionarioDB.setSalario(dadosFuncionario.getSalario());			
			repository.save(funcionarioDB);
		}		
	}
}
