package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dto.ContaComNumeroEAgencia;
import br.com.caelum.financas.util.JPAUtil;

public class TestDTO {
	public static void main(String[]args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String query ="select new br.com.caelum.financas.dto.ContaComNumeroEAgencia(c.numero, c.agencia) from tbl_conta c";
		
		List<ContaComNumeroEAgencia> contas = em.createQuery(query,ContaComNumeroEAgencia.class).getResultList();
		
		contas.forEach(conta ->{
			System.out.println("conta: "+conta.getAgencia()+" "+"Numero: "+conta.getNumeroConta());
		});
		
		
		em.close();
	}
}
