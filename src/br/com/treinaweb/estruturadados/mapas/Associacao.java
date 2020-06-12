package br.com.treinaweb.estruturadados.mapas;

public class Associacao<k,v> {
	
	private k chave;
	private v valor;
	
	public Associacao(k chave, v valor) {
		
		this.chave = chave;
		this.valor = valor;
		
	}

	public k getChave() {
		return chave;
	}

	public v getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Associacao [chave=" + chave + ", valor=" + valor + "]";
	}

}
