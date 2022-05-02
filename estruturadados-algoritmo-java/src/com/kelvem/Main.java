package com.kelvem;

public class Main {
	public static void main(String[] args) {
		Vetor lista = new Vetor(10);
		/*
		try {
			lista.adiciona("Curso Estrutura de Dados com Java");
			lista.adiciona("K");
			lista.adiciona(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//lista.adiciona("A");
		/*
		System.out.println(lista.tamanho());
		System.out.println(lista);
		//System.out.println(lista.busca(2));
		System.out.println(lista.busca("B"));
		System.out.println(lista.busca("Kelvem"));
		*/
		
		lista.adiciona("B");
		lista.adiciona("C");
		lista.adiciona("E");
		lista.adiciona("F");
		lista.adiciona("G");
		
		System.out.println(lista);
		lista.adiciona(0, "A");
		System.out.println(lista);
		lista.adiciona(3, "D");
		System.out.println(lista);
	}
}
