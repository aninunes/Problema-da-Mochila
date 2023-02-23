package com.mycompany.problemadamochila.algoritimo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgoritimoGenetico {
	private int tamanhoPopulacao;
	private List<Individuo> populacao = new ArrayList();
	private Individuo geracao;
	private Individuo melhorSolucao;
	
	public AlgoritimoGenetico (int tamanhoPopulacao) {
		this.tamanhoPopulacao = tamanhoPopulacao;
	}
	
	public void inicializaPopulacao(List espacos, List valores, Double limiteEspacos) {
		for (int i=0; i < tamanhoPopulacao; i++) {
			this.populacao.add(new Individuo(espacos, valores, limiteEspacos));
		}
		this.melhorSolucao= this.populacao.get(0);
	}
	public void melhorindividuo(Individuo individuo) {
		if (individuo.getNotaAvaliacao() > this.melhorSolucao.getNotaAvaliacao()){
			this.melhorSolucao = individuo;
		}
	}
	public Double somaAvaliacoes() {
		Double soma = 0.0;
		for(Individuo individuo: this.populacao) {
			soma += individuo.getNotaAvaliacao();
		}
		return soma;
	}
	
	public int selecionaPai(Double somaAvaliacao)
	{
		int pai=-1;
		Double valorSorteado = Math.random()* somaAvaliacao;
		Double soma = 0.0;
		int i = 0;
		while (i < this.populacao.size() && soma < valorSorteado) {
			soma += this.populacao.get(i).getNotaAvaliacao();
			pai +=1;
			i += 1;
		}
		return pai;
	}
	
	public void visualizaGeracao() {
		Individuo melhor = this.populacao.get(0);
		System.out.println("Geracao:" + melhor.getGeracao()+
				           " Valor:" +melhor.getNotaAvaliacao()+
				            " Espa�o:" + melhor.getPesoUsado()+
				            " Cromossomo:"+ melhor.getCromossomo());
	}

	public List resolver (Double taxaMutacao, int numeroGeracoes, List pesos, List beneficios, Double limitePeso) {
		this.inicializaPopulacao(pesos, beneficios, limitePeso);
		for (Individuo individuo: this.populacao) {
			individuo.avaliacao();
		}
		this.ordenaPopulacao();
		this.visualizaGeracao();
		
		for (int geracao =0; geracao < numeroGeracoes; geracao++) {
			Double somaAvaliacao = this.somaAvaliacoes();
			List<Individuo> novaPopulacao = new ArrayList();
			
		    for (int i=0; i< this.populacao.size() /2; i++) {
		      int pai1 = this.selecionaPai(somaAvaliacao);
		      int pai2 = this.selecionaPai(somaAvaliacao);
		      
		      List<Individuo> filhos = this.getPopulacao().get(pai1).crossover(this.getPopulacao().get(pai2));
		      novaPopulacao.add(filhos.get(0).mutacao(taxaMutacao));
		      novaPopulacao.add(filhos.get(1).mutacao(taxaMutacao));
		    }
		    
		    this.setPopulacao(novaPopulacao);
		    for (Individuo individuo: this.populacao) {
				individuo.avaliacao();
			}
		    this.ordenaPopulacao();
			this.visualizaGeracao();
			Individuo melhor = this.populacao.get(0);
			this.melhorindividuo(melhor);
		}
		System.out.println("Melhor solucao:" +this.melhorSolucao.getGeracao()+
				     " Valor:"+ this.melhorSolucao.getNotaAvaliacao()+
				     " Espa�o:"+ this.melhorSolucao.getPesoUsado()+ 
				     " Cromossomo: " + this.melhorSolucao.getCromossomo());
	  return this.melhorSolucao.getCromossomo();
	}
	
	public int getTamanhoPopulacao() {
		return tamanhoPopulacao;
	}

	public void setTamanhoPopulacao(int tamanhoPopulacao) {
		this.tamanhoPopulacao = tamanhoPopulacao;
	}

	public List<Individuo> getPopulacao() {
		return populacao;
	}

	public void setPopulacao(List<Individuo> populacao) {
		this.populacao = populacao;
	}

	public Individuo getGeracao() {
		return geracao;
	}

	public void setGeracao(Individuo geracao) {
		this.geracao = geracao;
	}

	public Individuo getMelhorSolucao() {
		return melhorSolucao;
	}

	public void setMelhorSolucao(Individuo melhorSolucao) {
		this.melhorSolucao = melhorSolucao;
	}
	
	public void ordenaPopulacao() {
		Collections.sort(this.populacao);
	}

}
