package com.qintess.desafio0104.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome", length = 45, nullable = false)
	private String nome;
	
	@Column(name="min_estoque", nullable = false)
	private int minEstoque;

	@Column(name="preco_venda", precision = 2, nullable = false)
	private double precoVenda;
	
	@Column(name="foto", length = 45, nullable = true)
	private String foto;
	
	@OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
	private List<VendaItens> vendaItens;

	@OneToMany(mappedBy = "produtoId")
	private List<FornecedorHasProduto> fornecedorProduto;
	
	public void add(VendaItens carrinho) {
		if(this.vendaItens == null) {
			this.vendaItens = new ArrayList<>();
		}
		this.vendaItens.add(carrinho);
	}
	
	public void add(FornecedorHasProduto carrinho) {
		if(fornecedorProduto == null) {
			fornecedorProduto = new ArrayList<>();
		}
		fornecedorProduto.add(carrinho);
	}
	
	
	public Produto() {
	}

	public Produto(String nome, int minEstoque, double precoVenda, String foto) {
		this.nome = nome;
		this.minEstoque = minEstoque;
		this.precoVenda = precoVenda;
		this.foto = foto;
	}

	public Produto(String nome, int minEstoque, double precoVenda) {
		this.nome = nome;
		this.minEstoque = minEstoque;
		this.precoVenda = precoVenda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMinEstoque() {
		return minEstoque;
	}

	public void setMinEstoque(int minEstoque) {
		this.minEstoque = minEstoque;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", minEstoque=" + minEstoque + ", precoVenda=" + precoVenda
				+ ", foto=" + foto + "]";
	}
}