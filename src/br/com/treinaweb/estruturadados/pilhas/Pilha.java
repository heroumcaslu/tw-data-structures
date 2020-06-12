package br.com.treinaweb.estruturadados.pilhas;

import br.com.treinaweb.estruturadados.listasligadas.ListaDuplamenteLigada;

public class Pilha<Tipo> {
	
	private ListaDuplamenteLigada<Tipo> elementos;
	
	public Pilha() {
		
		this.elementos = new ListaDuplamenteLigada<Tipo>();
		
	}
	
	public boolean estaVazia() {
		
		return this.elementos.estaVazia();
		
	}
	
	public void empilhar(Tipo elemento) {
		
		this.elementos.inserir(elemento);
		
	}
	
	public Tipo desempilhar() {
		
		if (estaVazia()) {
			
			return null;
			
		}
		Tipo resultado = this.elementos.recuperar(this.elementos.tamanho());
		this.elementos.remover(this.elementos.tamanho()-1);
		return resultado;
		
	}

}
