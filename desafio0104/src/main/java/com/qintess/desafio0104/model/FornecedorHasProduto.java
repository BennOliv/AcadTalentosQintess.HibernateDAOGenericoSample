package com.qintess.desafio0104.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor_has_produto")
public class FornecedorHasProduto implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="estoque")
	private int estoque;
	
	@Column(name="preco_custo")
	private double precoCusto;
	
	@Id
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="produto_id")
	private Produto produtoId;

	@Id
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedorId;
	
	
	public FornecedorHasProduto() {
	}

	public FornecedorHasProduto(int estoque, double precoCusto) {
		this.estoque = estoque;
		this.precoCusto = precoCusto;
	}

	public Fornecedor getFornecedor() {
		return fornecedorId;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedorId = fornecedor;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Produto getProduto() {
		return produtoId;
	}

	public void setProduto(Produto produto) {
		this.produtoId = produto;
	}

	@Override
	public String toString() {
		return "FornecedorHasProduto [estoque=" + estoque + ", precoCusto=" + precoCusto + ", produto=" + produtoId + "]";
	}

	
	
	
}
