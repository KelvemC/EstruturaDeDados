package com.kelvem;

import java.util.Collection;
import java.util.Collections;

public class ListaEncadeada {

	private No inicio;
	private No fim;
	private int totalDeElementos;

	// Adicionando no começo da lista:

	public void adicionaNoInicio(Object elemento) {
		// Instanciando a classe Nó passando o elemento
		No novo = new No(elemento, this.inicio);
		// Nó foi criado com o elemento passado pelo parâmetro, mas
		// seu inicio aponta para null
		this.inicio = novo;
		// agora inicio aponta para meu Nó criado

		// se ne não tiver nenhum elemento na minha lista encadeada, ou seja, se ele for
		// meu primeiro elemento
		// ele vai ser meu inico e fim.
		if (this.totalDeElementos == 0) {
			this.fim = novo;
		}
		// como um elemento foi adicionado o total de elementos é incrementado.
		this.totalDeElementos++;

	}

	// como inserir no final da lista
	public void adicionaNoFinal(Object elemento) {
		// se eu não tiver nenhum elemento na minha lista ele chama meu método adiciona
		// no começo
		// porque dá no mesmo.
		if (this.totalDeElementos == 0) {
			this.adicionaNoInicio(elemento);
		} else {
			// criando o nó
			No novo = new No(elemento);
			// atualizando a referência do próximo elemento que apontava para o null, agora
			// aponta para o novo.
			this.fim.setProximo(novo);
			// atualizando o fim para o novo;
			this.fim = novo;
			// novo agora aponta para null;
			this.totalDeElementos++;

		}
	}

	// método para percorer a lista
	public String toString() {
		if (this.totalDeElementos == 0) {
			return "[]";
		} else {

			/*
			 * Gráfico para tentar entender o que acontece no laço [60] --> [5] --> [8] -->
			 * [30] --> null total = 4; total-1 = 3 [60, 5, 8, 30]
			 * 
			 */
			// Criando Elemento to Tipo StringBuilder

			StringBuilder builder = new StringBuilder("[");
			No atual = this.inicio;
			for (int i = 0; i < this.totalDeElementos - 1; i++) {
				builder.append(atual.getElemento());
				builder.append(", ");
				atual = atual.getProximo();
			}
			builder.append(atual.getElemento());
			builder.append("]");
			return builder.toString();
		}

	}
	// inserindo em qualquer posição:

	// método para validar posição
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}

	// método para pegar nó anterior a posição que desejo inserir
	private No pegaNo(int posicao) {
		if (!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}
		No atual = this.inicio;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		return atual;
	}

	// método para adicionar em qualquer posição

	public void adiciona(int posicao, Object elemento) {
		if (posicao == 0) {
			this.adicionaNoInicio(elemento);
		} else if (posicao == this.totalDeElementos - 1) {
			this.adicionaNoFinal(elemento);
		} else {
			No anterior = this.pegaNo(posicao - 1);
			No novo = new No(elemento, anterior.getProximo());
			anterior.setProximo(novo);
			this.totalDeElementos++;
		}
	}

	public void removeInicio() {
		this.inicio = this.inicio.getProximo();
		this.totalDeElementos--;

		if (this.totalDeElementos == 0) {
			this.fim = null;
		}
	}

	public void removeFinal() throws IllegalArgumentException {
		if (this.totalDeElementos == 0) {
			System.out.println("Lista vazia, Não é possível remover");
		} else if (this.totalDeElementos == 1) {
			this.removeInicio();
		} else {
			No anterior = this.pegaNo(this.totalDeElementos - 2);
			anterior.setProximo(null);
			this.fim = anterior;
			this.totalDeElementos--;
		}
	}
	
	/*
	// questão1

	public boolean verificarOrdem() {
		No atual = this.inicio;
		No proximo = atual.getProximo();
		for (int i = 0; i < this.totalDeElementos - 1; i++) {
			if ((int) (atual.getElemento()) > (int) (proximo.getElemento())) {
				return false;
			}
			atual = atual.getProximo();
			proximo = atual.getProximo();
		}
		return true;
	}

	// questão 2
	public boolean verificaListas(ListaEncadeada lista) {
		if (this.totalDeElementos != lista.totalDeElementos) {
			System.out.println("As listas são diferentes!");
			return false;
		} else {
			No atual = this.inicio;
			No atualLista = lista.inicio;
			for (int i = 0; i < this.totalDeElementos; i++) {
				if (atual.getElemento().equals(atualLista.getElemento())) {
					atual = atual.getProximo();
					atualLista = atualLista.getProximo();
				} else {
					return false;
				}
			}
			return true;
		}
	}


	// questão 3
	public Object transfereValores(Object vetor[]) {
		ListaEncadeada novaLista = new ListaEncadeada();
		for (int i = 0; i < vetor.length; i++) {
			novaLista.adicionaNoFinal(vetor[i]);
		}
		return novaLista;
	}

	// questão 4
	public void copiaLista(ListaEncadeada listaE) {
		No atual = getInicio();
		No proximo = atual.getProximo();
		for (int i = 0; i < this.totalDeElementos; i++) {
			if((int)(atual.getElemento()) < (int)(proximo.getElemento())){
				listaE.adicionaNoFinal(atual.getElemento());
				atual = atual.getProximo();
			}
			else {
				listaE.adicionaNoInicio(atual.getElemento());
				// listaE.adicionaNoInicio(proximo.getElemento());
				atual = atual.getProximo();
				
			}
		}
		//ordenando lista
		

		System.out.println(listaE);
	}
	*/
	
	//ATIVIDADE RESOLUÇÃO
	
	//Questão 01
	
	public String verificaOrdem(ListaEncadeada lista) {
		No atual = this.inicio;
		for(int i =0; i < this.totalDeElementos-1; i++) {
			No proximo = atual.getProximo();
			//ORDEM CRESCENTE
			if((int)atual.getElemento() > (int)proximo.getElemento()) {
				System.out.println("Lista não ordenada!");
				break;
			}
			atual = atual.getProximo();
		}
		
		return "Lista ordenada!";
	}
	//Questão 2
	public String verificaLista(ListaEncadeada x, ListaEncadeada y) {
		if(x.totalDeElementos !=y.totalDeElementos) {
			return "Listas diferentes";
		}
		No atualx = x.inicio;
		No atualy = y.inicio;
		
		for(int i = 0; i < x.totalDeElementos-1; i++) {
			if(!(atualx.getElemento().equals(atualy.getElemento()))){
				return "listas diferentes";
			}
			atualx = atualx.getProximo();
			atualy = atualy.getProximo();
		}
		return "Iguais";
	}
	
	//Questão 3
	public void transfereValores(Object[] elementos) {
		for(int i = 0; i<elementos.length; i++) {
			this.adicionaNoFinal(elementos[i]);
		}
		System.out.println("Lista depois de inserção: ");
		System.out.println(this.toString());
	}
	
	//Questão 4
	
	public void copiaLista(ListaEncadeada x) {
		ListaEncadeada y = new ListaEncadeada();
		System.out.println("Valores de x: "+x);
		while(x.totalDeElementos > 0) {			
			No atual = x.inicio;
			No maior = atual;
			int pos = 0;
			for(int i = 0; i < x.totalDeElementos; i++) {
				if((int)atual.getElemento() > (int)maior.getElemento()) {
					maior = atual;
					pos = i;
				}
				atual = atual.getProximo();
			}
			y.adicionaNoFinal(maior.getElemento());
			if(pos==0) {
				x.removeInicio();
			}else {
				No anteriorMaior = x.pegaNo(pos-1);
				anteriorMaior.setProximo(maior.getProximo());
				x.totalDeElementos--;				
			}
		}
		System.out.println("Valores de x após remoção: " + x);
		System.out.println("Valores de y: " + y);
	}
	
	//Questão 5
	
	public void removeAteX(ListaEncadeada lista, int x) {
		No anteriorNovoInicio = lista.pegaNo(x);
		lista.inicio = anteriorNovoInicio.getProximo();
		lista.totalDeElementos-=x+1;
	}
	
	
	public boolean remove(int posicao) {
		if(this.posicaoValida(posicao)) {
			if(posicao==0) {
				this.removeInicio();
				return true;
			}else if(posicao ==this.totalDeElementos-1) {
				this.removeFinal();
				return true;
			}else {
				No anterior = this.pegaNo(posicao-1);
				No atual = anterior.getProximo();
				anterior.setProximo(atual.getProximo());;
				this.totalDeElementos--;
				return true;
			}
		}else {
			return false;
		}
	}
	
	public boolean contem(Object elemento) {
		No atual = this.inicio;
		for(int i = 0; i < this.totalDeElementos; i++) {
			if(atual.getElemento().equals(elemento)) return true;
			atual = atual.getProximo();
		}
		return false;
	}
	
	
	//-----------------------------
	public No getInicio() {
		return inicio;
	}

	public void setInicio(No inicio) {
		this.inicio = inicio;
	}

	public No getFim() {
		return fim;
	}

	public void setFim(No fim) {
		this.fim = fim;
	}

	public int getTotalDeElementos() {
		return totalDeElementos;
	}

	public void setTotalDeElementos(int totalDeElementos) {
		this.totalDeElementos = totalDeElementos;
	}
}