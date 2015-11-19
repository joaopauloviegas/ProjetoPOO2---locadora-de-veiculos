package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRpositorioCadastroSaidaDeVeiculos {

	public void cadastrarSaidaDeVeiculo(CadastroSaidaDeVeiculos saidaVeiculo);
	public void atualizarSaidaDeVeiculo(CadastroSaidaDeVeiculos saidaVeiculo);
	public boolean removerSaidaDeVeiculo(int id);
	public CadastroSaidaDeVeiculos procurarSaidaDeVeiculo(String placa);
	public ArrayList<CadastroSaidaDeVeiculos> listarSaidaDeVeiculo() throws SQLException;
	
	
	
	
}// fim da interface
