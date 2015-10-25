package com.fafica.projeto.Carro;

import java.util.ArrayList;

import com.fafica.projeto.Cliente.CampoObrigatorioException;

public class ControladorCarro {

	private IRepositorioCarro repositorioCarro;

	public ControladorCarro() {
		
		this.repositorioCarro = new RepositorioCarro();
				
	}
	//METODO CADASTRAR
	public void cadastarCarro(Carro carro) throws CarroJaCadastradoException,
												  CampoObrigatorioException,
												  IllegalArgumentException {
	
		if(carro == null) throw new IllegalAccessError("Carro Invalido");
		if(carro.getPlaca().equals(""))throw new CampoObrigatorioException("placa");
		if(carro.getNome().equals(""))throw new CampoObrigatorioException("nome");
		this.repositorioCarro.cadastrarCarro(carro);
	}
	
	//METODDO ATUALIZAR 
	public void atualizarCarro(Carro carro) throws CarroNaoEncontradoException,
	                                       		   CampoObrigatorioException,
												   IllegalArgumentException{
		
		if(carro == null) throw new IllegalArgumentException("Carro invalido");
		if(carro.getPlaca().equals(""))throw new CampoObrigatorioException("placa");
		if(carro.getNome().equals(""))throw new CampoObrigatorioException("nome");
		this.repositorioCarro.atualizarCarro(carro);
	}
	
	
	//METODDO REMOVER
	public boolean removerCarro(Carro placa) throws CarroNaoEncontradoException,
													CampoObrigatorioException,
													IllegalArgumentException{
		
		if(placa == null) throw new IllegalArgumentException("Placa invalida");
		if(placa.getPlaca().equals("")) throw new CampoObrigatorioException("placa");
		
		return this.repositorioCarro.removerCarro(placa);
	}
	
	
	//METODO PROCURAR
	public Carro procurarCarro(Carro placa) throws CarroNaoEncontradoException,
												   CampoObrigatorioException{
		Carro carro = null;
		if(placa.getPlaca() == null) throw new CarroNaoEncontradoException();
		if(placa.getPlaca().equals("")) throw new CampoObrigatorioException("placa");
		
		carro = this.repositorioCarro.procurarCarro(placa);
		return carro;
	}
	
	
	// METODO LISTAR
	public ArrayList<Carro> listarCarro(){
		return this.repositorioCarro.listarCarro();
	}
	
	
	
	
}// fim da classe
