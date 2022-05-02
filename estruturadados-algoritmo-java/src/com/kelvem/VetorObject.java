package com.kelvem;

public class VetorObject {
	private Object[] elementos;
	private int tamanho = 0;
	
	
	public VetorObject(int capacidade) {
		this.elementos = new Object[capacidade];
	}
	
	//Adicionando elementos em um vetor de forma eficiente
	public boolean adiciona(Object elemento) {
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
	public Object busca(int posicao) {
		if(!((posicao>=0) && (posicao<this.tamanho))) {
			throw new IllegalArgumentException("Posição inválida");
		}
		return this.elementos[posicao];
	}
	
	//Verificando se o elemento existe no vetor
	public int busca(Object elemento) {
		//fazendo a busca sequencial
		for(int i = 0; i < this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)){
				return i;
			}
		}
		return -1;
	}
	
	//verificar se existe mais de uma ocorrência de um elemento passado como parâmetro.
	/*
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
		
	}*/
	
	//Adicionar um elemento em qualquer posição do vetor
	public boolean adiciona(int posicao, Object elemento) {
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
			Object[] elementosNovos = new Object[this.elementos.length*2];
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
}
