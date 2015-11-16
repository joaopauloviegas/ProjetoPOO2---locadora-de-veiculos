package com.fafica.projeto.Carro;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto.Cliente.CampoObrigatorioException;

public class ControladorCarro {

	private IRepositorioCarro repositorioCarro;

	public ControladorCarro() {
		
		//this.repositorioCarro = new RepositorioCarro();
		this.repositorioCarro = new RepositorioCarroBD();
				
	}
	//METODO CADASTRAR
	public void cadastarCarro(Carro carro) throws CarroJaCadastradoException,
												  CampoObrigatorioException,
												  IllegalArgumentException, 
												  SQLException {
	
		if(carro == null) throw new IllegalAccessError("Carro Invalido");
		if(carro.getPlaca().equals(""))throw new CampoObrigatorioException("placa");
		if(carro.getNome().equals(""))throw new CampoObrigatorioException("nome");
		System.out.println("estou no controlador");
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
	public boolean removerCarro(String placa) throws CarroNaoEncontradoException,
													CampoObrigatorioException,
													IllegalArgumentException{
		
		if(placa == null) throw new IllegalArgumentException("Placa invalida");
		if(placa.equals("")) throw new CampoObrigatorioException("placa");
		
		return this.repositorioCarro.removerCarro(placa);
	}
	
	
	//METODO PROCURAR
	public Carro procurarCarro(String placa) throws CarroNaoEncontradoException,
												   CampoObrigatorioException{
		Carro c = null;
		if(placa == null) throw new CarroNaoEncontradoException();
		if(placa.equals("")) throw new CampoObrigatorioException("placa");
		
		c = this.repositorioCarro.procurarCarro(placa);
		return c;
	}
	
	
	// METODO LISTAR
	public ArrayList<Carro> listarCarro() throws SQLException, CarroNaoEncontradoException{
		System.out.println("to no controlador");
		return this.repositorioCarro.listarCarro();
	}
	
	
	
	
}// fim da classe
