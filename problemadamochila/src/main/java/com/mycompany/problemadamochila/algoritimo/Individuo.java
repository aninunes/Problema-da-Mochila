package com.mycompany.problemadamochila.algoritimo;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Individuo implements Comparable<Individuo>{
	private List pesos = new ArrayList();
	private List beneficios = new ArrayList();
	private Double limitePeso;
	private Double notaAvaliacao;
	private Double pesoUsado;
	private int geracao;
	private List cromossomo = new ArrayList();
	
	public Individuo(List pesos, List beneficios, Double limitePeso) {
		super();
		this.pesos = pesos;
		this.beneficios = beneficios;
		this.limitePeso = limitePeso;
		this.notaAvaliacao = 0.0;
		this.pesoUsado = 0.0;
		this.geracao = 0;
		
		for (int i =0; i< this.pesos.size(); i++) {
			if (java.lang.Math.random() < 0.5)
				this.cromossomo.add("0");
			else
				this.cromossomo.add("1");
			
		}
		
		
	}
	
	public void avaliacao (){
		Double nota = 0.0;
		Double somaEspacos = 0.0;
		for (int i=0; i< cromossomo.size(); i++) {
			if (this.cromossomo.get(i).equals("1")) {
			nota += (Double) this.beneficios.get(i);
		    somaEspacos += (Double)	this.pesos.get(i);
			} 		
		}
		if (somaEspacos > this.limitePeso) {
			nota = 1.0;
		}
		
		this.notaAvaliacao = nota;
		this.pesoUsado = somaEspacos;
	}
	
	public List crossover (Individuo outroindividuo) {
		int corte = (int) Math.round(Math.random() * this.cromossomo.size());
	    
		List filho1 = new ArrayList();
	    filho1.addAll(outroindividuo.getCromossomo().subList(0, corte));
	    filho1.addAll(this.cromossomo.subList(corte, this.cromossomo.size()));
	    
	    List filho2 = new ArrayList();
	    filho2.addAll(this.cromossomo.subList(0, corte));
	    filho2.addAll(outroindividuo.getCromossomo().subList(corte, this.cromossomo.size()));
	    
	    List<Individuo> filhos = new ArrayList();
	    filhos.add(new Individuo(this.pesos, this.beneficios, this.limitePeso));
	    filhos.add(new Individuo(this.pesos, this.beneficios, this.limitePeso));
	    
	    filhos.get(0).setCromossomo(filho1);
	    filhos.get(0).setGeracao(this.geracao+1);
	    filhos.get(1).setCromossomo(filho2);
	    filhos.get(1).setGeracao(this.geracao+1);
	    
	   return filhos;
	}
	
	public Individuo mutacao (Double taxaMutacao) {
		System.out.println("Antes da mutacao: "+ this.cromossomo);
		for (int i=0; i < this.cromossomo.size(); i++) {
			if (Math.random() < taxaMutacao) {
				if (this.cromossomo.get(i).equals("0")) {
					this.cromossomo.set(i, "1");
			}else {
				this.cromossomo.set(i, "0");
			}
		}
	 }	
		System.out.println("Depois da mutacao: "+ this.cromossomo);		
	  return this;	
	}

	public Double getPesoUsado() {
		return pesoUsado;
	}



	public void setPesoUsado(Double pesoUsado) {
		this.pesoUsado = pesoUsado;
	}



	public List getPesos() {
		return pesos;
	}

	public void setPesos(List pesos) {
		this.pesos = pesos;
	}

	public List getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List valores) {
		this.beneficios = beneficios;
	}

	public Double getLimitePeso() {
		return limitePeso;
	}

	public void setLimitePeso(Double limitePeso) {
		this.limitePeso = limitePeso;
	}

	public Double getNotaAvaliacao() {
		return notaAvaliacao;
	}

	public void setNotaAvaliacao(Double notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}

	public int getGeracao() {
		return geracao;
	}

	public void setGeracao(int geracao) {
		this.geracao = geracao;
	}

	public List getCromossomo() {
		return cromossomo;
	}

	public void setCromossomo(List cromossomo) {
		this.cromossomo = cromossomo;
	}
	
@Override
public int compareTo (Individuo o) {
	if (this.notaAvaliacao > o.getNotaAvaliacao()) {
		return -1;
	}
	if (this.notaAvaliacao < o.getNotaAvaliacao()) {
		return 1;
	}
	return 0;
}
	
	
}
