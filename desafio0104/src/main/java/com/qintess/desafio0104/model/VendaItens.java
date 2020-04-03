package com.qintess.desafio0104.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="venda_itens")
public class VendaItens {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="quantidade", nullable = false)
	private int quantidade;

	@Column(name="preco_custo", precision = 2, nullable = false)
	private double precoCusto;
	
	@Column(name="preco_unit", precision = 2, nullable = false)
	private double precoUnit;
	
	@ManyToOne
	@JoinColumn(name="produto_id", nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="venda_id", nullable = false)
	private Venda venda;

	public VendaItens() {
	}

	public VendaItens(int quantidade, double precoCusto, double precoUnit, Produto produto, Venda venda) {
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.precoUnit = precoUnit;
		this.produto = produto;
		this.venda = venda;
	}

	public VendaItens(int quantidade, double precoCusto, double precoUnit) {
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.precoUnit = precoUnit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public double getPrecoUnit() {
		return precoUnit;
	}

	public void setPrecoUnit(double precoUnit) {
		this.precoUnit = precoUnit;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public String toString() {
		return "VendaItens [id=" + id + ", quantidade=" + quantidade + ", precoCusto=" + precoCusto + ", precoUnit="
				+ precoUnit + ", produto=" + produto.getId() + ", venda=" + venda.getId() + "]";
	}
	
	
	
}
