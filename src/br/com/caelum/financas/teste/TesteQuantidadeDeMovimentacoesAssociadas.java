package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

public class TesteQuantidadeDeMovimentacoesAssociadas {

	public static void main (String [] args){
		
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO dao = new ContaDAO(em);
		
		em.getTransaction().begin();
		
		Conta conta = dao.busca(36);
		System.out.println(conta.getMovimentacoes().size());
		//System.out.println(conta.getTitular());
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		System.out.println(conta.getMovimentacoes().size());
		em.close();
	}
}
