package com.qintess.desafio0104.Util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.desafio0104.model.Fornecedor;
import com.qintess.desafio0104.model.FornecedorHasProduto;
import com.qintess.desafio0104.model.Produto;
import com.qintess.desafio0104.model.Venda;
import com.qintess.desafio0104.model.VendaItens;


public class HibernateConfig {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				
				Configuration config = new Configuration();
				
				Properties prop = new Properties();
				
				//prop do bd
				prop.put(Environment.DRIVER, "org.h2.Driver");
				prop.put(Environment.URL, "jdbc:h2:~/desafio0104");
				prop.put(Environment.USER, "sa");
				prop.put(Environment.PASS, "");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
				
				prop.put(Environment.SHOW_SQL, "true");
				//comentei porque fica dando erro (por casua das relações)
//				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				config.setProperties(prop);
				
				config.addAnnotatedClass(Fornecedor.class);
				config.addAnnotatedClass(FornecedorHasProduto.class);
				config.addAnnotatedClass(Produto.class);
				config.addAnnotatedClass(Venda.class);
				config.addAnnotatedClass(VendaItens.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
														.applySettings(config.getProperties())
														.build();
				
				sessionFactory = config.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
