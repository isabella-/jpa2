package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.EntityManager;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.dao.MovimentacaoDAO;

public class TesteSalvaMovimentacaoSemConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();

		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(entityManager);
		
		entityManager.getTransaction().begin();

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("conta de luz - abril/2010");
		movimentacao.setValor(new BigDecimal("100"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);

		
		dao.adiciona(movimentacao);
		entityManager.persist(movimentacao);
		entityManager.getTransaction().commit();
		entityManager.close();

		System.out.println("Movimentacao gravada com sucesso!");

		long fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim - inicio));

	}
	
}
