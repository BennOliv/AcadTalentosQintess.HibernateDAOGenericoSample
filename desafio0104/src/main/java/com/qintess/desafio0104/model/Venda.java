package com.qintess.desafio0104.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="venda")
public class Venda {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="desconto", nullable = false)
	private int desconto;
	
	@Column(name="forma_pagamento", nullable = false)
	private int formaPag;
	
	@Column(name="TIMESTAMP", nullable = false)
	private LocalDate data;
	
	@Column(name="cliente_id", nullable = false)
	private int clienteId;
	
	@OneToMany(mappedBy = "venda")
	private List<VendaItens> carrinho;
	
	public void add(VendaItens carrinho) {
		if(this.carrinho == null) {
			this.carrinho = new ArrayList<>();
		}
		this.carrinho.add(carrinho);
	}

	public Venda() {
	}

	public Venda(int desconto, int formaPag, LocalDate data, int clienteId) {
		this.desconto = desconto;
		this.formaPag = formaPag;
		this.data = data;
		this.clienteId = clienteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public int getFormaPag() {
		return formaPag;
	}

	public void setFormaPag(int formaPag) {
		this.formaPag = formaPag;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", desconto=" + desconto + ", formaPag=" + formaPag + ", data=" + data
				+ ", clienteId=" + clienteId + "]";
	}
}
