package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class TestaBuscaComContaDaMovimentacao {

	public static void main (String [] args){
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		Movimentacao movimentacao = new Movimentacao();
		movimentacao = dao.busca(5);
		System.out.println("O titular dessa conta e: " + movimentacao.getConta().getTitular());
		
		em.getTransaction().commit();
		em.close();
		

	}
}
