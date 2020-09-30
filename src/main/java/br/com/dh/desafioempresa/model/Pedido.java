package br.com.dh.desafioempresa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties({ "fkCliente", "bookCategory" })
public class Pedido {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private int id;
	
	@Column(name = "numero_pedido")
	private int numeroPedido;
	
	@Column(name = "nome_produto")
	private String nomeProduto;
	
	@Column(name = "preco_produto")
	private double precoProduto;

	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	@JsonProperty("fkCliente")	
	private Cliente fkCliente;
	
	public Pedido() {
		
	}
	
	public Pedido(int numeroPedido, String nomeProduto, Long precoProduto, Cliente fkCliente) {
		super();
		this.numeroPedido = numeroPedido;
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
		this.fkCliente = fkCliente;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Cliente getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(Cliente fkCliente) {
		this.fkCliente = fkCliente;
	}

	public int getId() {
		return id;
	}
	
	
	
}
