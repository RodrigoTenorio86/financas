package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestTransientConta {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setBanco("Caixa Econômica");
		conta.setAgencia("123");
		conta.setNumero("456");
    //---->Transient
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
	//----->Manager	
		em.persist(conta);
		conta.setBanco("Banco do Brasil");
		em.getTransaction().commit();
		em.close();

	}
}
