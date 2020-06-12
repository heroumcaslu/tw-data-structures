package br.com.treinaweb.estruturadados.conjuntos;

import br.com.treinaweb.estruturadados.espalhamento.TabelaEspalhamento;

public class Conjunto<Tipo> {

	private TabelaEspalhamento<Tipo> elementos;

	Conjunto() {

		this.elementos = new TabelaEspalhamento<Tipo>();

	}

	public boolean inserir(Tipo elemento) {

		return this.elementos.inserir(elemento);

	}

	public boolean estaVazio() {
		
		return this.elementos.tamanho() == 0;
		
	}

	public int tamanho() {

		return this.elementos.tamanho();

	}

	public boolean contem(Tipo elemento) {

		return this.elementos.contem(elemento);

	}

//	public int indice(Tipo elemento) {
//
//		return this.elementos.indice(elemento);
//
//	}

//	public void remover(int posicao) {
//
//		this.elementos.remover(posicao);
//
//	}

	public void remover(Tipo elemento) {

		this.elementos.remover(elemento);

	}

//	private boolean contemOtimizado(Tipo elemento) {
//
//		for (int i = 0; i < this.elementos.tamanho(); i++) {
//
//			Tipo ele = this.elementos.recuperar(i);
//			if (ele.hashCode() == elemento.hashCode()) {
//
//				return true;
//
//			}
//
//		}
//		return false;
//
//	}

	@Override
	public String toString() {
		return "Conjunto [elementos=" + elementos + "]";
	}

}
