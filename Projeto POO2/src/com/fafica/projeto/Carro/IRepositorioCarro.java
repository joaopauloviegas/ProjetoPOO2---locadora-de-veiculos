package com.fafica.projeto.Carro;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioCarro {

	public void cadastrarCarro(Carro carro) throws SQLException;
	public void atualizarCarro(Carro carro);
	public boolean removerCarro(Carro placa);
	public Carro procurarCarro(Carro placa);
	public ArrayList<Carro> listarCarro() throws SQLException;
	
	
	
}// fim da interface
