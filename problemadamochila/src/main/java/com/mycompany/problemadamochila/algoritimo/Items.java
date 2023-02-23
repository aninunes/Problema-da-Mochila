package com.mycompany.problemadamochila.algoritimo;

public class Items {
	private String nome;
	private Double espaco;
	private Double valor;
	
	public String getNome() {
		return nome;
	}
	
	public Items (String nome, Double espaco, Double valor) {
		super();
		this.nome = nome;
		this.espaco = espaco;
		this.valor = valor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getEspaco() {
		return espaco;
	}
	public void setEspaco(Double espaco) {
		this.espaco = espaco;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

}
