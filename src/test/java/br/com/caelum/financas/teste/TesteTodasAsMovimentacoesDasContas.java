package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select c from tbl_conta c join fetch c.movimentacaos";
		//String jpql = "select c from tbl_conta c";//problema N +1
		
		Query query = em.createQuery(jpql);
		
		List<Conta> contas = query.getResultList();
		
		contas.forEach(conta->{
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentacoes: "+conta.getMovimentacaos().size());
		});
	}

}
