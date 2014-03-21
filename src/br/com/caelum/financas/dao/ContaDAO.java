package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.caelum.financas.modelo.Conta;

public class ContaDAO {

		private final DAO<Conta> dao;
		
		public ContaDAO(EntityManager em){
			dao = new DAO<Conta>(em,Conta.class);
		}
		
		public void adiciona(Conta t){
			this.dao.adiciona(t);
		}
		
		public Conta busca(Integer id){
			return this.dao.busca(id);
		}
		
		public List<Conta> lista(){
			return this.dao.lista();
		}
		
		public void remove(Conta t){
			this.dao.remove(t);
		}
}
