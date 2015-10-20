package com.fafica.projeto.Carro;

import java.util.ArrayList;

public class ControladorCarro {

	private IRepositorioCarro repositorioCarro;

	public ControladorCarro() {
		
		this.repositorioCarro = new RepositorioCarro();
				
	}
	
	public void cadastarCarro(Carro carro){
	
		this.repositorioCarro.cadastrarCarro(carro);
	}
	
	public void atualizarCarro(Carro carro){
		this.repositorioCarro.atualizarCarro(carro);
	}
	
	public boolean removerCarro(Carro placa){
		return this.repositorioCarro.removerCarro(placa);
	}
	
	public Carro procurarCarro(Carro placa){
		Carro carro = null;
		
		carro = this.repositorioCarro.procurarCarro(placa);
		return carro;
	}
	
	public ArrayList<Carro> listarCarro(){
		return this.repositorioCarro.listarCarro();
	}
	
	
	
	
}// fim da classe
