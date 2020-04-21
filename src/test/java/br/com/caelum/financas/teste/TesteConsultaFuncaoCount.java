package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String jpql =  "select distinct avg(m.valor) from tbl_movimentacao m where m.conta = :pConta" 
					 + " and m.tipo = :pTipo " 
					 + " group by day(m.data), month(m.data), year(m.data)";
		Conta conta= new Conta();
		conta.setId(2);
		
		TypedQuery<Double> query = em.createQuery(jpql,Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = query.getResultList();
		
		medias.forEach(m ->{
			System.out.println("Valor medio "+m);
		});
		
		em.getTransaction().commit();
		em.close();
	}
}
