package br.com.treinaweb.estruturadados.arvorebinaria;

public abstract class NodeArvore<Tipo> {
	
	protected Tipo valor;
	private NodeArvore<Tipo> noEsquerdo;
	private NodeArvore<Tipo> noDireito;
	
	public NodeArvore(Tipo valor) {
		
		this.valor = valor;
		this.noEsquerdo = null;
		this.noDireito = null;
		
	}
	
	public NodeArvore<Tipo> getNoEsquerdo() {
		return noEsquerdo;
	}
	public void setNoEsquerdo(NodeArvore<Tipo> noEsquerdo) {
		this.noEsquerdo = noEsquerdo;
	}
	public NodeArvore<Tipo> getNoDireito() {
		return noDireito;
	}
	public void setNoDireito(NodeArvore<Tipo> noDireito) {
		this.noDireito = noDireito;
	}
	public Tipo getValor() {
		return valor;
	}
	
	public abstract int peso();

	@Override
	public String toString() {
		return (this.noEsquerdo == null ? "[NULO]" : "["+this.noEsquerdo.toString()+"]" )
				+(this.noDireito == null ? "[NULO]" : "["+ this.noDireito.toString()+"]");
	}

}
