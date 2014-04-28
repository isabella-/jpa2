package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaEntityManagerFactoryParaAtualizarBanco {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("controlefinancas");
	
	public EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
		
	}
}
