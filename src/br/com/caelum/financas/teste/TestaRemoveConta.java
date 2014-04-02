package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaRemoveConta {
	
	public static void main (String [] args){
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO dao = new ContaDAO(em);
		em.clear();
		em.getTransaction().begin();
		
		
		Conta conta = dao.busca(4);
		dao.remove(conta);
		
		System.out.println(conta.getBanco());
		
		em.getTransaction().commit();
		em.close();
		
		
	}
}
