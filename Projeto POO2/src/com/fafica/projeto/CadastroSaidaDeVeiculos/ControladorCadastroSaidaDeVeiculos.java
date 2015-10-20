package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.util.ArrayList;

public class ControladorCadastroSaidaDeVeiculos {

	private IRpositorioCadastroSaidaDeVeiculos repositorioCadastroSaidaVeiculo;
	
	//construtor
	public ControladorCadastroSaidaDeVeiculos(){
		this.repositorioCadastroSaidaVeiculo = new RepositorioCadastroSaidaDeVeiculos();
	}
	
	public void cadastrarSaidaDeVeiculos(CadastroSaidaDeVeiculos saidaVeiculo){
		this.repositorioCadastroSaidaVeiculo.cadastrarSaidaDeVeiculo(saidaVeiculo);
	}
	
	public void atualizarSaidaDeVeiculo(CadastroSaidaDeVeiculos saidaVeiculo){
		this.repositorioCadastroSaidaVeiculo.atualizarSaidaDeVeiculo(saidaVeiculo);
	}
	
	public boolean removerSaidaDeVeiculo(CadastroSaidaDeVeiculos codigoLocacao){
		return this.repositorioCadastroSaidaVeiculo.removerSaidaDeVeiculo(codigoLocacao);
	}
	
	public CadastroSaidaDeVeiculos procurarSaidaDeVeiculo(CadastroSaidaDeVeiculos codigoLocacao){
		CadastroSaidaDeVeiculos locacao;
		
		locacao = this.repositorioCadastroSaidaVeiculo.procurarSaidaDeVeiculo(codigoLocacao);
		return locacao;
	}
	
	public ArrayList<CadastroSaidaDeVeiculos> listarSaidaVeiculo(){
		return this.repositorioCadastroSaidaVeiculo.listarSaidaDeVeiculo();
	}
}// fim da classe
