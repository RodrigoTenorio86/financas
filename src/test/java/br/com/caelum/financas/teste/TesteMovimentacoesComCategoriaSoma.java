package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoriaSoma {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
	//	String jpql = "select sum(m.valor) from tbl_movimentacao m where m.conta = :pConta"
	//				+ " and m.tipo = :pTipo"
	//				+ " order by m.valor desc";
		
	//	Query query = em.createQuery(jpql);
	//	query.setParameter("pConta", conta);
	//	query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		TypedQuery<BigDecimal> typedQuery= em.createNamedQuery("Movimentacao.uniaoContaSomar", BigDecimal.class);
							   typedQuery.setParameter("pConta", conta)	;
							   typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
	//	BigDecimal soma = (BigDecimal) query.getSingleResult();
		BigDecimal soma = typedQuery.getSingleResult();
		
		System.out.println(soma);
		
		em.getTransaction().commit();
		em.close();
	}
}
