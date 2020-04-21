package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "tbl_movimentacao")
@NamedQueries({
	@NamedQuery(query = "select max(m.valor) from tbl_movimentacao m where m.conta = :pConta", 	name = "funcaoMax"),
	@NamedQuery(query = "select m from tbl_movimentacao m join m.categoria c where c = :pCategoria", name="Movimentacao.uniaoCategoria"),
	@NamedQuery(query = "select sum(m.valor) from tbl_movimentacao m where m.conta = :pConta and m.tipo = :pTipo order by m.valor desc", name="Movimentacao.uniaoContaSomar"),
	@NamedQuery(query = "select m from tbl_movimentacao m join m.categoria c where c = :pCategoria and m.valor < 500 and m.tipo = :pTipoMovimentacao", name="Movimentacao.CalcularValorAcimar500")
})
public class Movimentacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(precision = 18, scale = 2)
	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDate data;
	private String descricao;
	@ManyToMany
	private List<Categoria> categoria;	
	@ManyToOne
	private Conta conta;
	
	
	
	public List<Categoria> getCategoria() {
		return categoria;
	}
	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoMovimentacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
}
