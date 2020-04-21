package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConsulta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		//String jpql = "select m from tbl_movimentacao m join m.categoria c where c = :pCategoria";
		
		//Query query = em.createQuery(jpql);
		//query.setParameter("pCategoria", categoria);
		TypedQuery<Movimentacao> typedQuery = em.createNamedQuery("Movimentacao.uniaoCategoria", Movimentacao.class);
		typedQuery.setParameter("pCategoria", categoria);
		
		//List<Movimentacao> resulList = query.getResultList();
		List<Movimentacao> resulList = typedQuery.getResultList();
		
		resulList.forEach(m ->{
			System.out.println("Descricao: "+m.getDescricao());
		});
		
		em.close();
	}
}
