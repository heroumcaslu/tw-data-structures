package br.com.treinaweb.estruturadados.arvorebinaria;

public class Arvore<Tipo> {
	
	private NodeArvore<Tipo> raiz;
	
	public Arvore() {
		
		this.raiz = null;
		
	}
	
	public NodeArvore<Tipo> getRaiz(){
		
		return this.raiz;
		
	}
	
	public void inserir (NodeArvore<Tipo> no) {
		
		no.setNoEsquerdo(null);
		no.setNoDireito(null);
		
		if (this.raiz == null) {
			
			this.raiz = no;
			
		} else {
			
			this.inserir(this.raiz, no);
			
		}
		
	}
	
	private void inserir(NodeArvore<Tipo> ref, NodeArvore<Tipo> novoNo) {
		
		if (ref.peso() < novoNo.peso()) {
			
			if (ref.getNoDireito() == null) {
				
				ref.setNoDireito(novoNo);
				
			} else {
				
				inserir(ref.getNoDireito(), novoNo);
				
			}
			
		} else {
			
			if (ref.getNoEsquerdo() == null) {
				
				ref.setNoEsquerdo(novoNo);
				
			} else {
				
				inserir(ref.getNoEsquerdo(), novoNo);
				
			}
			
		}
		
	}
	
	private NodeArvore<Tipo> buscar(NodeArvore<Tipo> ref, NodeArvore<Tipo> noBusca) {
		
		if (ref.getValor().equals(noBusca.getValor())) {
			
			return ref;
			
		} else {
			
			if (ref.peso() < noBusca.peso()) {
				
				//tem que ir a direita
				if (ref.getNoDireito() == null) {
					
					throw new IllegalArgumentException("Elemento não encontrado");
					
				} else {
					
					System.out.println(">>> Navegando à direita do nó"+ref.getValor());
					return buscar(ref.getNoDireito(), noBusca);
					
				}
				
			} else {
				
				// Tem que ir a esquerda
				if (ref.getNoEsquerdo() == null) {
					
					throw new IllegalArgumentException("Elemento não encontrado");
					
				} else {
					
					System.out.println(">>> Navegando à esquerda do nó");
					return buscar(ref.getNoEsquerdo(), noBusca);
					
				}
				
			}
			
		}
		
	}
	
	public NodeArvore<Tipo> buscar(NodeArvore<Tipo> busca){
		
		return this.buscar(this.raiz, busca);
		
	}
	
	public void emOrdem() {
		
		//ERD Esquerda - Raiz - Direita
		this.emOrdem(this.raiz);
		
	}
	
	public void preOrdem() {
		
		//RED
		this.preOrdem(this.raiz);
		
	}
	
	public void posOrdem() {
		
//		EDR
		this.posOrdem(this.raiz);
		
	}
	
	public int altura() {
		
		return this.altura(this.raiz);
		
	}
	
	private int altura(NodeArvore<Tipo> ref) {
		// TODO Auto-generated method stub
		if(ref == null) {
			
			return -1;
			
		}
		int alturaEsquerda = altura(ref.getNoEsquerdo());
		int alturaDireita = altura(ref.getNoDireito());
		return alturaEsquerda > alturaDireita ? alturaEsquerda + 1 : alturaDireita +1;
	}

	private void posOrdem(NodeArvore<Tipo> ref) {
		// TODO Auto-generated method stub
		
		if (ref.getNoEsquerdo() != null) {
			
			posOrdem(ref.getNoEsquerdo());
			if (ref.getNoDireito() != null) {
				
				posOrdem(ref.getNoDireito());
				
			}
			System.out.println(ref.getValor().toString());
			
		} else {
			
			if (ref.getNoDireito() != null) {
				
				posOrdem(ref.getNoDireito());
				System.out.println(ref.getValor().toString());
				
			} else {
				
				System.out.println(ref.getValor().toString());
				
			}
			
		}
		
	}

	private void emOrdem(NodeArvore<Tipo> ref) {
		
		if (ref.getNoEsquerdo() != null) {
			
			emOrdem(ref.getNoEsquerdo());
			System.out.println(ref.getValor().toString());
			if (ref.getNoDireito()!= null) {
				
				emOrdem(ref.getNoDireito());
				
			}
			
		} else {
			
			System.out.println(ref.getValor().toString());
			if (ref.getNoDireito() != null) {
				
				emOrdem(ref.getNoDireito());
				
			}
			
		}
		
	}
	
	private void preOrdem(NodeArvore<Tipo> ref) {
		
		System.out.println(ref.getValor().toString());
		if (ref.getNoEsquerdo() != null) {
			
			preOrdem(ref.getNoEsquerdo());
			if (ref.getNoDireito()!= null) {
				
				preOrdem(ref.getNoDireito());
				
			} else {
				
				if (ref.getNoDireito() != null) {
					
					preOrdem(ref.getNoDireito());
					
				}
				
			}
			
		}
		
	}
	
	@Override
	public String toString() {
		return this.raiz == null ? "[NULO]" : this.raiz.toString();
	}

}
