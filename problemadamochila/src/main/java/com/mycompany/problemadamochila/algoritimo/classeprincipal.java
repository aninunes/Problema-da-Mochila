package com.mycompany.problemadamochila.algoritimo;

import java.util.ArrayList;
import java.util.List;


public class classeprincipal {
	
	public static void main(String args[]) {
		
     List<Items>listaItems = new ArrayList();
     listaItems.add(new Items("Item1", 5.0, 3.0));
     listaItems.add(new Items("Item2", 4.0, 3.0));
     listaItems.add(new Items("Item3", 7.0, 2.0));
     listaItems.add(new Items("Item4", 8.0, 4.0));
     listaItems.add(new Items("Item5", 4.0, 2.0));
     listaItems.add(new Items("Item6", 4.0, 3.0));
     listaItems.add(new Items("Item7", 6.0, 4.0));
     listaItems.add(new Items("Item8", 8.0, 2.0));

     
     List espacos = new ArrayList();
     List valores = new ArrayList(); 
     List nomes = new ArrayList();
     
     for (Items items: listaItems) {
	    espacos.add(items.getEspaco());
	    valores.add(items.getValor());
	    nomes.add(items.getNome());
	}
    
     Double limite = 3.0;
     
     int tamanhopopulacao = 20;
     Double taxaMutacao = 0.01;
     int numeroGeracoes = 100;
     
     AlgoritimoGenetico ag = new AlgoritimoGenetico(tamanhopopulacao);
     List resultado = ag.resolver(taxaMutacao, numeroGeracoes, espacos, valores, limite);
     for (int i=0; i < listaItems.size(); i++) {
    	 if(resultado.get(i).equals("1")) {
    		 System.out.println("Nome: "+ listaItems.get(i).getNome());
    	 }
     }
     
  }
}
