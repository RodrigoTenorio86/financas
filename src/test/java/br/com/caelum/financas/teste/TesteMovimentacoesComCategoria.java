package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import static java.util.Arrays.asList;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	public static void main(String[]args) {
        Conta conta = new Conta();
        conta.setId(2); 
		
        Categoria categoria1 = new Categoria();
        categoria1.setNome("viagem");

        Categoria categoria2 = new Categoria();
        categoria2.setNome("negócios");
        
        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(LocalDate.now()); //hoje
        movimentacao1.setDescricao("Viagem à SP");
        movimentacao1.setTipo(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal("100.0"));
        movimentacao1.setCategoria(asList(categoria1, categoria2));

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setData(LocalDate.now()); // hoje
        movimentacao2.setDescricao("Viagem ao RJ");
        movimentacao2.setTipo(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("300.0"));
        movimentacao2.setCategoria(asList(categoria1, categoria2));
        
        movimentacao1.setConta(conta);
        movimentacao2.setConta(conta);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        em.persist(categoria1); // Agora a 'categoria1' é Managed
        em.persist(categoria2); // Agora a 'categoria2' é Managed

        
        em.persist(movimentacao1);
        em.persist(movimentacao2);
        
        em.getTransaction().commit();
        em.close();

        
	}
}
