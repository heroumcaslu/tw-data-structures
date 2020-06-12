package br.com.treinaweb.estruturadados.mapas;

import br.com.treinaweb.estruturadados.listasligadas.ListaLigada;

public class Mapa<k, v> {

	private ListaLigada<ListaLigada<Associacao<k, v>>> elementos;
	private int quantidadedeCategorias = 16;

	public Mapa() {
		
		this.elementos = new ListaLigada<ListaLigada<Associacao<k, v>>>();
		for (int i=0; i<quantidadedeCategorias; i++) {
			
			this.elementos.inserir(new ListaLigada<Associacao<k,v>>());
			
		}
		
	}
	
	private int gerarEspalhamento(k chave) {
		
		return Math.abs(chave.hashCode() % quantidadedeCategorias);
		
	}
	
	public boolean contemChave(k chave) {
		
		int numeroEspalhamento = this.gerarEspalhamento(chave);
		ListaLigada<Associacao<k,v>> categoria = this.elementos.recuperar(numeroEspalhamento);
		for (int i = 0; i < categoria.tamanho(); i++) {
			
			Associacao<k, v> associacao = categoria.recuperar(i);
			if (associacao.getChave().equals(chave)) {
				
				return true;
				
			}
			
		}
		return false;
	}
	
	public void remover(k chave) {
		
		int numeroEspalhamento = this.gerarEspalhamento(chave);
		ListaLigada<Associacao<k,v>> categoria = this.elementos.recuperar(numeroEspalhamento);
		for (int i = 0; i<categoria.tamanho(); i++) {
			
			Associacao<k, v> associacao = categoria.recuperar(i);
			if (associacao.getChave().equals(chave)) {
				
				categoria.remover(associacao);
				return;
				
			}
			
		}
		throw new IllegalArgumentException(String.format("A chave %s não existe", chave));
		
	}
	
	public void adicionar(k chave, v valor) {
		
		if (this.contemChave(chave)) {
			
			this.remover(chave);
			
		}
		int numeroEspalhamento = this.gerarEspalhamento(chave);
		ListaLigada<Associacao<k, v>> categoria = this.elementos.recuperar(numeroEspalhamento);
		categoria.inserir(new Associacao<k, v>(chave, valor));
		
	}
	
	public v recuperar (k chave) {
		
		int numeroEspalhamento = this.gerarEspalhamento(chave);
		ListaLigada<Associacao<k, v>> categoria = this.elementos.recuperar(numeroEspalhamento);
		for (int i =10; i< categoria.tamanho(); i++) {
			
			Associacao<k, v> associacao = categoria.recuperar(i);
			if(associacao.getChave().equals(chave)) {
				
				return associacao.getValor();
				
			}
			
		}
		throw new IllegalArgumentException(String.format("A chave %s não existe", chave));
		
	}

	@Override
	public String toString() {
		return "Mapa [elementos=" + elementos + "]";
	}
	
	

}
