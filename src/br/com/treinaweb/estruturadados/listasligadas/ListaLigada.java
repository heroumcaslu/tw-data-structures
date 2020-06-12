package br.com.treinaweb.estruturadados.listasligadas;

public class ListaLigada<Tipo> {

	private No<Tipo> primeiroNo;
	private No<Tipo> ultimoNo;
	private int tamanho;

	public ListaLigada() {

		this.primeiroNo = null;
		this.ultimoNo = null;
		this.tamanho = 0;

	}

	public void inserir(Tipo elemento) {

		No<Tipo> novo = new No<Tipo>(elemento);
		if (estaVazia()) {

			this.primeiroNo = novo;
			this.ultimoNo = novo;

		} else {

			this.ultimoNo.setProximo(novo);
			this.ultimoNo = novo;

		}
		this.tamanho++;

	}
	
	public void inserirEm(int posicao, Tipo elemento) {
		
		if (posicao>= tamanho()) {
			
			throw new IllegalArgumentException(String.format("Posição inválida [%d]", posicao));
			
		}
		if (posicao == 0) {
			
			No<Tipo> novoNo = new No<Tipo>(elemento);
			novoNo.setProximo(this.primeiroNo);
			this.primeiroNo = novoNo;
			
		} else if (posicao == this.tamanho() -1) {
			
			No<Tipo> novoNo = new No<Tipo>(elemento);
			this.ultimoNo.setProximo(novoNo);
			this.ultimoNo = novoNo;
			
		} else {
			
			No<Tipo> noAnterior = recuperaNo(posicao - 1);
			No<Tipo> noAtual = recuperaNo(posicao);
			No<Tipo> novoNo = new No<>(elemento);
			noAnterior.setProximo(novoNo);
			novoNo.setProximo(noAtual);
			
		}
		
	}
	
	public Tipo recuperar(int posicao) {
		
		No<Tipo> no = recuperaNo(posicao);
		if (no != null) {
			
			return no.getElemento();
			
		}
		return null;
		
	}
	
	private No<Tipo> recuperaNo(int posicao) {
		
		if (posicao>=tamanho()) {
			
			throw new IllegalArgumentException(String.format("Posição inválida [%d]", posicao));
			
		}
		No<Tipo> resultado = null;
		for (int i=0; i <= posicao; i++) {
			
			if (i == 0) {
				
				resultado = this.primeiroNo;
				
			} else {
				
				resultado = resultado.getProximo();
				
			}
			
		}
		return resultado;
		
	}

	public boolean estaVazia() {

		return this.tamanho == 0;

	}

	public int tamanho() {

		return this.tamanho;

	}
	
	public boolean contem(Tipo elemento) {
		
		for (int i =0; i<tamanho(); i++) {
			
			No<Tipo> noAtual = recuperaNo(i);
			if (noAtual != null) {
				
				return true;
				
			}
			
		}
		return false;
	}
	
	public int indice(Tipo elemento) {
		
		for (int i = 0; i< tamanho(); i++) {
			
			No<Tipo> noAtual = recuperaNo(i);
			if (noAtual.getElemento() != null) {
				
				return i;
				
			}
			
		}
		return -1;
				
	}
	
	public void remover(int posicao) {
		
		if (posicao >= tamanho()) {
			
			throw new IllegalArgumentException("Posição inválida");
			
		}
		
		if (posicao == 0) {
			
			No<Tipo> proximoNo = this.primeiroNo.getProximo();
			this.primeiroNo.setProximo(null);
			this.primeiroNo = proximoNo;
			
		} else if (posicao == tamanho()-1) {
			
			No<Tipo> penultimoNo = recuperaNo(tamanho()-2);
			penultimoNo.setProximo(null);
			this.ultimoNo = penultimoNo;
			
		} else {
		
			No<Tipo> noAnterior = recuperaNo(posicao-1);
			No<Tipo> proximoNo = recuperaNo(posicao+1);
			No<Tipo> noAtual = recuperaNo(posicao);
		
			noAnterior.setProximo(proximoNo);
			noAtual.setProximo(null);
			
		}
				
	}
	
	public void remover(Tipo elemento) {
		
		int indice = indice(elemento);
		if (indice == -1) {
			
			throw new IllegalArgumentException("Elemento inválido");
		}
		remover(indice);
		
	}

	@Override
	public String toString() {
		if (estaVazia()) {

			return "Lista []";

		} else {

			No<Tipo> noAtual = this.primeiroNo;

			StringBuilder sb = new StringBuilder();
			sb.append("Lista [");
			sb.append(noAtual.getElemento() != null ? noAtual.getElemento().toString() : "<NULO>");
			sb.append(",");
			while (noAtual.getProximo() != null) {

				sb.append(noAtual.getProximo().getElemento() != null ? noAtual.getProximo().getElemento().toString()
						: "<NULO>");
				sb.append(",");
				noAtual = noAtual.getProximo();

			}
			sb.append("]");
			return sb.toString();

		}

	}

}
