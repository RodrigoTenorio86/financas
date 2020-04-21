package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author rtenorio
 * resolver problema
 */
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;
//Ao analisar seus gastos, João percebeu que estava gastando muito com viagens e precisava economizar. Como podemos trazer todas as viagens de João que custaram acima de R$ 500,00?
public class TestMovimentacoes {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Categoria lanche = new Categoria();
		lanche.setNome("Lanche");
		
		//String jpql ="select m from tbl_movimentacao m join m.categoria c where c = :pCategoria and m.valor > 500 and m.tipo = :pTipoMovimentacao";
		
		//Query query = em.createQuery(jpql);
		
		TypedQuery<Movimentacao> typedQuery = em.createNamedQuery("Movimentacao.CalcularValorAcimar500", Movimentacao.class);
								 typedQuery.setParameter("pCategoria", lanche); 
								 typedQuery.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);		
		
		//query.setParameter("pCategoria", viagem);
		//query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);
		
		//List<Movimentacao> movimentacaos = query.getResultList();
		List<Movimentacao> movimentacaos = typedQuery.getResultList();
		
		movimentacaos.forEach(m->{
			System.out.println("Categoria: "+m.getDescricao());
		});
		
		em.getTransaction().commit();
		em.close();
	
	}
}
