package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestDistinct {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql= "select distinct c from tbl_conta c left join fetch c.movimentacaos";//certa
		//String jpql="select conta.titular from tbl_conta conta inner join tbl_movimentacao movimentacao on conta.id=movimentacao.conta.id";
		
		Query query = em.createQuery(jpql);
		
		List<Conta>contas= query.getResultList();
		
		contas.forEach(conta ->{
			System.out.println("Titular: "+conta.getTitular()+" "+"Movimentacoes: "+conta.getMovimentacaos().size());
			System.out.println();
		});
		
		em.getTransaction().commit();
		em.close();
	}
}
