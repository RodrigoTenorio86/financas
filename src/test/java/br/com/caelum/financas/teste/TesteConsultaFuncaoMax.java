package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {
	public static void main(String [] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		//String jpql = "select max(m.valor) from tbl_movimentacao m where m.conta = :pConta";
		TypedQuery<BigDecimal> typeQuery = em.createNamedQuery("funcaoMax", BigDecimal.class);
		
		//Query query = em.createQuery(jpql);
		//query.setParameter("pConta", conta);
		
		typeQuery.setParameter("pConta", conta);
		
		BigDecimal max = (BigDecimal) typeQuery.getSingleResult();
		
		System.out.println("Valor maximo "+max);
		
		
		em.getTransaction().commit();
		em.close();
	}
}
