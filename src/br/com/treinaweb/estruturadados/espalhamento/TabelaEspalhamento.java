package br.com.treinaweb.estruturadados.espalhamento;

import br.com.treinaweb.estruturadados.listasligadas.ListaLigada;

public class TabelaEspalhamento<Tipo> {

	private ListaLigada<ListaLigada<Tipo>> elementos;
	private int numeroCategorias = 16;
	private int tamanho;

	public TabelaEspalhamento() {

		this.elementos = new ListaLigada<ListaLigada<Tipo>>();
		for (int i = 0; i < this.numeroCategorias; i++) {

			this.elementos.inserir(new ListaLigada<Tipo>());

		}

	}

	public boolean inserir(Tipo elemento) {

		if (elemento == null || this.contem(elemento)) {

			return false;

		}
		int numEspalhamento = this.gerarNumEspalhamento(elemento);
		ListaLigada<Tipo> categoria = this.elementos.recuperar(numEspalhamento);
		categoria.inserir(elemento);
		this.tamanho++;
		return true;

	}

	public void remover(Tipo elemento) {

		int numEspalhamento = this.gerarNumEspalhamento(elemento);
		ListaLigada<Tipo> categoria = this.elementos.recuperar(numEspalhamento);
		categoria.remover(elemento);
		this.tamanho--;

	}

	public int tamanho() {

		return this.tamanho;

	}

	public boolean contem(Tipo elemento) {

		int numEspalhamento = this.gerarNumEspalhamento(elemento);
		ListaLigada<Tipo> categoria = this.elementos.recuperar(numEspalhamento);
		return categoria.contem(elemento);

	}

	private int gerarNumEspalhamento(Tipo elemento) {

		return Math.abs(elemento.hashCode() % this.numeroCategorias);

	}

	@Override
	public String toString() {
		return "TabelaEspalhamento [elementos=" + elementos + "]";
	}

}
