package com.fafica.projeto.Carro;

import java.util.ArrayList;

public class RepositorioCarro implements IRepositorioCarro {

	@Override
	public void cadastrarCarro(Carro carro) {
		
		
		System.out.println("Estou no repositorio"  + carro);
		
	}

	@Override
	public void atualizarCarro(Carro carro) {
		
		
	}

	@Override
	public boolean removerCarro(Carro placa) {
		
		return false;
	}

	@Override
	public Carro procurarCarro(Carro placa) {
		
		return null;
	}

	@Override
	public ArrayList<Carro> listarCarro() {
		
		return null;
	}

	
}// fim da classe
