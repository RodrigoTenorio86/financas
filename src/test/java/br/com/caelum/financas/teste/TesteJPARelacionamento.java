package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String[] args) {
	    Conta conta = new Conta();
	    conta.setAgencia("0102");
	    conta.setBanco("Itau");
	    conta.setNumero("1234");
	    conta.setTitular("Leonardo");

	    Movimentacao movimentacao = new Movimentacao();
	    movimentacao.setData(LocalDate.now());	    		
	    movimentacao.setDescricao("Churrascaria");
	    movimentacao.setTipo(TipoMovimentacao.SAIDA);
	    movimentacao.setValor(new BigDecimal("200.0"));	
	    
	    movimentacao.setConta(conta);

	    EntityManager em = new JPAUtil().getEntityManager();
	    em.getTransaction().begin();
	    
	    em.persist(conta);
	    em.persist(movimentacao);

	    em.getTransaction().commit();
	    em.close();
	    
	}
}
