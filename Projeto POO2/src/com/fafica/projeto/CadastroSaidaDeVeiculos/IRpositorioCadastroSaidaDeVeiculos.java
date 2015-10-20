package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.util.ArrayList;

public interface IRpositorioCadastroSaidaDeVeiculos {

	public void cadastrarSaidaDeVeiculo(CadastroSaidaDeVeiculos saidaVeiculo);
	public void atualizarSaidaDeVeiculo(CadastroSaidaDeVeiculos saidaVeiculo);
	public boolean removerSaidaDeVeiculo(CadastroSaidaDeVeiculos codigoLocacao);
	public CadastroSaidaDeVeiculos procurarSaidaDeVeiculo(CadastroSaidaDeVeiculos codigoLocacao);
	public ArrayList<CadastroSaidaDeVeiculos> listarSaidaDeVeiculo();
	
	
	
	
}// fim da interface
