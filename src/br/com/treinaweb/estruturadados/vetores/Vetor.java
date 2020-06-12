package br.com.treinaweb.estruturadados.vetores;

import java.util.Arrays;
//Generics
public class Vetor<Tipo> {

	//Array do tipo objeto
	private Object[] elementos;
	private int posicao;

	public Vetor (int capacidade) {

		this.elementos = new Object[capacidade];

	}

	public void inserir(Tipo elemento) {

		if (this.posicao >= this.elementos.length) {
			 //Atribui uma copia do array com um elemento a mais
			this.elementos = Arrays.copyOf(this.elementos, this.elementos.length+1);

		}

		this.elementos[this.posicao] = elemento;
		this.posicao++;

	}

	public void inserirEm(int posicao, Tipo elemento) {

		if (posicao > this.elementos.length) {

			throw new IllegalArgumentException(String.format("Posição é inválida %d", posicao));

		}
		if (this.elementos[posicao] != null) {

			Object[] arrayFinal = Arrays.copyOfRange(this.elementos, posicao, this.elementos.length);
			Object[] arrayInicio = new Object[posicao + 1];
			System.arraycopy(this.elementos, 0, arrayInicio, 0, posicao);
			arrayInicio[arrayInicio.length - 1] = elemento;
			int novoTamanho = arrayInicio.length + arrayFinal.length;
			this.elementos = new Object[novoTamanho];
			System.arraycopy(arrayInicio, 0, this.elementos, 0, arrayInicio.length);
			System.arraycopy(arrayFinal, 0, this.elementos, arrayInicio.length, arrayFinal.length);

		}
		this.elementos[posicao] = elemento;
		this.posicao++;

	}

	@SuppressWarnings("unchecked")
	public Tipo recuperar(int posicao) {

		if (posicao >= tamanho()) {

			throw new IllegalArgumentException(String.format("Posição inválida [%d]", posicao));
		}

		return (Tipo) this.elementos[posicao];

	}

	public int tamanho() {

		return this.elementos.length;

	}

	public boolean contem(Tipo elemento) {

		for (int i = 0; i < tamanho(); i++) {

			Tipo elem = recuperar(i);
			if (elem != null && elem.equals(elemento)) {

				return true;

			}

		}
		return false;

	}

	public int indice(Tipo elemento) {

		for (int i = 0; i < tamanho(); i++) {

			Tipo elem = recuperar(i);
			if (elem != null && elem.equals(elemento)) {

				return i;

			}

		}
		return -1;

	}
	
	public void remover(int posicao) {
		
		if (posicao >= tamanho()) {
			
			throw new IllegalArgumentException(String.format("Posição inválida %d", posicao));
			
		}
		Object[] arrayInicio = Arrays.copyOfRange(this.elementos, 0, posicao);
		Object[] arrayFinal = Arrays.copyOfRange(this.elementos, posicao+1, tamanho());
		this.elementos = new Object[tamanho()-1];
		this.posicao--;
		System.arraycopy(arrayInicio, 0, this.elementos, 0, arrayInicio.length);
		System.arraycopy(arrayFinal, 0, this.elementos, arrayInicio.length, arrayFinal.length);

	}
	
	public void remover(Tipo elemento) {
		
		int posicao = indice(elemento);
		if (posicao >= tamanho() || posicao == -1) {
			
			throw  new IllegalArgumentException("Elemento inválido "+elemento.toString());
			
		}
		remover(posicao);
		
	}

	@Override
	public String toString() {
		return "Vetor [elementos=" + Arrays.toString(elementos) + ", posicao=" + posicao + "]";
	}


}
