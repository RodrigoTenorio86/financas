package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestDetachedConta {
	public static void main(String[] args) {
		//Transient
		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setBanco("Caixa Econômica");
		conta.setAgencia("123");
		conta.setNumero("456");

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		//Transient -> Managed
		em.persist(conta);
		System.out.println("ID "+conta.getId());
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		
		conta.setTitular("Maria da Penha");
		conta.setBanco("Caixa Econômica");
		conta.setAgencia("321");
		conta.setNumero("741");
		//Detached
		em2.merge(conta);
		
		em2.getTransaction().commit();
		em2.close();
		
		

	}
}
