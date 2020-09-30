package br.com.dh.desafioempresa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private int id;
	
	private String nome;
	private String endereco;
	
	@OneToMany(mappedBy = "fkCliente")
	private List<Pedido> pedido;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String endereco, List<Pedido> pedido) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.pedido = pedido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public int getId() {
		return id;
	}
	
	
	
}
