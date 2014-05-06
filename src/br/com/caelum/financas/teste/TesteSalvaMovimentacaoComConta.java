package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.dao.TagDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.Tag;



public class TesteSalvaMovimentacaoComConta {
	
	private static String tags;
	
	public static String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	private static void gravaEAssociaAsTags(EntityManager em){
		
		String [] nomesDasTags = tags.split(" ");
		TagDAO tagDAO = new TagDAO(em);
		Movimentacao movimentacao = new Movimentacao();
		
		for(String nome : nomesDasTags){
			Tag tag = tagDAO.adicionaOuBuscaTagComNome(nome);
			movimentacao.getTags().add(tag);
		}
	}
	
	public void grava(){
		
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO contaDAO = new ContaDAO(em);
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(em);
		em.getTransaction().begin();
		
		Conta conta = contaDAO.busca(7);
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setConta(conta);
		gravaEAssociaAsTags(em);
		movimentacaoDAO.adiciona(movimentacao);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
	
	public static void main (String [] args){
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
			
		Conta conta = new Conta();
		conta.setBanco("Banco Santander");
		conta.setNumero("99999-9");
		conta.setAgencia("999");
		conta.setTitular("Maria");
		
		em.persist(conta);
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("conta de luz - abril/2010");
		movimentacao.setValor(new BigDecimal("100"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		
		em.close();
		
	
	}

}
