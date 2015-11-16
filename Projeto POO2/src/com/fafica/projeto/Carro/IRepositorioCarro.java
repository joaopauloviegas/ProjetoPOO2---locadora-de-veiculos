package com.fafica.projeto.Carro;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioCarro {

	public void cadastrarCarro(Carro carro) throws SQLException;
	public void atualizarCarro(Carro carro);
	public boolean removerCarro(String placa);
	public Carro procurarCarro(String placa) throws CarroNaoEncontradoException;
	public ArrayList<Carro> listarCarro() throws SQLException, CarroNaoEncontradoException;
	
	
	
}// fim da interface
