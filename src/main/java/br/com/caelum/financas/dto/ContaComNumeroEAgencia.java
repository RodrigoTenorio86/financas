package br.com.caelum.financas.dto;

public class ContaComNumeroEAgencia {
	private String numero;
	private String agencia;

	public ContaComNumeroEAgencia(String numero, String agencia) {
		this.numero = numero;
		this.agencia = agencia;
	}

	public String getNumeroConta() {
		return numero;
	}

	public String getAgencia() {
		return agencia;
	}
}
