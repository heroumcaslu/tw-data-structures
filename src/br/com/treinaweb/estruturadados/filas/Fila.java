package br.com.treinaweb.estruturadados.filas;

import br.com.treinaweb.estruturadados.listasligadas.ListaLigada;

public class Fila<Tipo> {
	
	private ListaLigada<Tipo> elementos;
	
	public Fila() {
		
		this.elementos = new ListaLigada<Tipo>();
		
	}
	
	public void enfileirar(Tipo elemento) {
		
		this.elementos.inserir(elemento);
		
	}
	
	public Tipo desenfileirar() {
		
		if (estaVazia()) {
			
			return null;
			
		}
		Tipo resultado = this.elementos.recuperar(0);
		this.elementos.remover(0);
		return resultado;
		
	}
	
	public boolean estaVazia() {
		
		return this.elementos.estaVazia();
		
	}

	@Override
	public String toString() {
		return "Fila [" + elementos.toString() + "]";
	}

	
	
}
