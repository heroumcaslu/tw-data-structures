package br.com.treinaweb.estruturadados.main;

import br.com.treinaweb.estruturadados.modelo.Pessoa;
import br.com.treinaweb.estruturadados.vetores.Vetor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vetor<Pessoa> person = new Vetor<Pessoa>(3);
		person.inserir(new Pessoa(1, "Lucas Herom"));
		person.inserir(new Pessoa(2, "Rosa Bernadete"));
		person.inserir(new Pessoa(2, "Rosa Bernadete"));
		System.out.println(person.toString());

		person.inserirEm(1, new Pessoa(4, "Luana Leite"));
		System.out.println(person);
		

	}

}
