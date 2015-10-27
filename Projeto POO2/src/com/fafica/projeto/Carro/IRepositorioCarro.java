package com.fafica.projeto.Carro;

import java.util.ArrayList;

public interface IRepositorioCarro {

	public void cadastrarCarro(Carro carro);
	public void atualizarCarro(Carro carro);
	public boolean removerCarro(Carro placa);
	public Carro procurarCarro(Carro placa);
	public ArrayList<Carro> listarCarro();
	
	
	
}// fim da interface
