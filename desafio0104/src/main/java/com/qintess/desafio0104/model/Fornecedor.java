package com.qintess.desafio0104.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor")
public class Fornecedor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="telefone")
	private	String telefone;
	
	@Column(name="contato")
	private String contato;
	
	@OneToMany(mappedBy = "fornecedorId",
				cascade = CascadeType.ALL,
				orphanRemoval = true)
	private List<FornecedorHasProduto> produtosFornecedor;

	public Fornecedor() {
	}

	public Fornecedor(String nome, String telefone, String contato) {
		this.nome = nome;
		this.telefone = telefone;
		this.contato = contato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public List<FornecedorHasProduto> getProdutosFornecedor() {
		return produtosFornecedor;
	}

	public void setProdutosFornecedor(List<FornecedorHasProduto> produtosFornecedor) {
		this.produtosFornecedor = produtosFornecedor;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", contato=" + contato + "]";
	}
	
	
}