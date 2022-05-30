package com.kelvem;

import java.util.Arrays;

public class Vetor {
	
	private String[] elementos;
	private int tamanho = 0;
	private int capacidade;
	private int ocorrencia;
	
	
	public Vetor(int capacidade) {
		this.capacidade = capacidade;
		this.elementos = new String[capacidade];
	}
	/*
	 * Esse método não é eficiente
	public void adiciona(String elemento) {
		for(int i = 0; i < this.elementos.length; i++) {
			if(this.elementos[i] == null) {
				this.elementos[i] = elemento;
				break;
			}
		}
	}
	*/
	
	/*
	 * Adiciona Elementos com tratamento de exception
	public void adiciona(String elemento) throws Exception {
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
		}else {
			throw new Exception("Vetor já está cheio, não é possível adicionar mais elementos.");
		}
	}
	*/
	
	//Adicionando elementos em um vetor de forma eficiente
	public boolean adiciona(String elemento) {
		aumentaCapacidade();
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}
	
	//Retornando o tamanho real do vetor
	public int tamanho() {
		return this.tamanho;
	}
	
	//Imprimir os elementos do vetor - não eficiente
	/*
	public String toString() {
		String s = "[";
		for(int i = 0; i<this.tamanho-1; i++) {
			s+=this.elementos[i];
			s+=", ";
		}
		if(tamanho>0) {
			s+=this.elementos[this.tamanho-1];
			s+=", ";
		}
		
		s+="]";
		return s;
	}
	*/
	
	//Imprimindo os elementos do vetor - forma eficiente
	public String toString() {	
		StringBuilder s = new StringBuilder();
		s.append("[");
		for(int i = 0; i<this.tamanho-1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}
		if(tamanho>0) {
			s.append(this.elementos[this.tamanho-1]);
			
		}
		
		s.append("]");
		return s.toString();
	}
	
	//Buscar elemento em uma determinada posição - tamanho real da lista
	public String busca(int posicao) {
		if(!((posicao>=0) && (posicao<this.tamanho))) {
			throw new IllegalArgumentException("Posição inválida");
		}
		return this.elementos[posicao];
	}
	
	//Verificando se o elemento existe no vetor
	public int busca(String elemento) {
		//fazendo a busca sequencial
		for(int i = 0; i < this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)){
				return i;
			}
		}
		return -1;
	}
	
	//verificar se existe mais de uma ocorrência de um elemento passado como parâmetro.
	
	public boolean verifica(String elemento) {
		int contador = 0;
		for(int i = 0; i<this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)) {
				contador++;
			}
			if(contador>1) {
				return true;
			}	
		}
		return false;
		
	}
	
	
	//Adicionar um elemento em qualquer posição do vetor
	public boolean adiciona(int posicao, String elemento) {
		aumentaCapacidade();
		if(!((posicao>=0) && (posicao<this.tamanho))) {
			throw new IllegalArgumentException("Posição inválida");
		}
		//mover todos os elementos 
		for(int i = this.tamanho-1; i>=posicao; i--) {
			this.elementos[i+1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		tamanho++;
		
		return true;
	}
	
	private void aumentaCapacidade() {
		if(this.tamanho == this.elementos.length) {
			String[] elementosNovos = new String[this.elementos.length*2];
			for(int i = 0; i < this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}
	
	//Removendo um elemento de qualquer posição
	
	public void remove(int posicao) {
		if(!((posicao>=0) && (posicao<this.tamanho))) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		for(int i = posicao; i<this.tamanho-1; i++) {
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
		
	}
	/*
	//Questão 1
	public void limpar() {
		String[] listaLimpa;
		listaLimpa = new String[capacidade];
		this.elementos = listaLimpa;
		this.tamanho = 0;
	}
	
	//Questão 2
	public int procura(String elemento) {
		for(int i = 0; i < this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)){
				this.ocorrencia = i;
			}
		
		}
		return ocorrencia;
	}
	//Questão3
	public void removeC(String elemento) {
		for(int i = 0; i<this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)) {
				remove(i);
				
			}
		
		}
		
	}
	*/
	
	//Questão 1
	public void limpa() {
		this.tamanho = 0;
		/*
		this.tamanho = 0;
		for(int i =0; i < this.tamanho; i++) {
			this.elementos[i] = null;
		}
		*/
	}
	
	//Questão 2
	
	public int retornarIndice(String elemento) {
		//Melhor forma
		for(int i = tamanho-1; i>=0; i--) {
			if(this.elementos[i].equals(elemento)){
				return i;
			}
		}
		return -1;
	}
	//Questão 3
	public void removeOcorre(String elemento) {
		for(int i = tamanho-1; i>=0; i--) {
			if(this.elementos[i].equals(elemento)) {
				remove(i);
			}
		}
	}
	
}
		
