package com.kelvem;
import java.util.ArrayList;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ListaEncadeada lista = new ListaEncadeada();
		lista.adicionaNoInicio("SALGUEIRO");
		System.out.println(lista);
		lista.adicionaNoInicio("CABROBÓ");
		System.out.println(lista);
		
		lista.adicionaNoFinal("PETROLINA");
		System.out.println(lista);
		
		lista.adiciona(1, "CAJAZEIRAS");
		System.out.println(lista);
		
		lista.adiciona(2, "RECIFE");
		System.out.println(lista);
		*/
		ListaEncadeada lista = new ListaEncadeada();
		lista.adicionaNoInicio(100);
		lista.adicionaNoInicio(60);
		lista.adicionaNoInicio(1800);
		lista.adicionaNoInicio(0);
		
		ListaEncadeada lista2 = new ListaEncadeada();
		//verificando ondem, result = true;
		lista2.adicionaNoInicio(100);
		lista2.adicionaNoInicio(60);
		lista2.adicionaNoInicio(1800);
		lista2.adicionaNoInicio(0);
		
		
		//verificando ordem
		/*
		System.out.println(lista2.verificarOrdem());
		System.out.println(lista.verificaListas(lista2));
		
		//transferindo o valor de um vetor para uma lista encadeada.
		
		Object vetor[] = {1,2,3,4};
		System.out.println(lista.transfereValores(vetor));
		*/
		//copiando valore.
		
		//System.out.println(lista.verificaLista(lista, lista2));
		//Object[] elementos = {"vasco", "flamengo","botafogo"};
		//lista.transfereValores(elementos);
		//lista.copiaLista(lista2);
		System.out.println(lista);
		//lista.removeAteX(lista, 2);
		lista.remove(2);
		System.out.println(lista);
	}

}
