package com.qintess.desafio0104.controller;

import com.qintess.desafio0104.DAO.Dao;
import com.qintess.desafio0104.model.Produto;

public class App{
    public static void main( String[] args ){
    	
    	Dao<Produto> produtoDAO = new Dao<>();
    	
    	System.out.println("Registro no BD[ "+ produtoDAO.buscaTodos(Produto.class) +" ]");
    }
}