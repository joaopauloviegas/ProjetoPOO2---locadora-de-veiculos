package com.fafica.projeto.Carro;

import java.util.ArrayList;

public class RepositorioCarro implements IRepositorioCarro {

	@Override
	public void cadastrarCarro(Carro carro) {
		System.out.println("Estou no repositorio"  + carro);
		
	}

	@Override
	public void atualizarCarro(Carro carro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removerCarro(Carro placa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Carro procurarCarro(Carro placa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Carro> listarCarro() {
		// TODO Auto-generated method stub
		return null;
	}

	
}// fim da classe
