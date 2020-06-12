package br.com.treinaweb.estruturadados.arvorebinaria;

import br.com.treinaweb.estruturadados.modelo.Pessoa;

public class NodeArvorePessoa extends NodeArvore<Pessoa> {

	public NodeArvorePessoa(Pessoa valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int peso() {
		// TODO Auto-generated method stub
		return this.valor.getId();
	}

}
