package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.util.ArrayList;

import com.fafica.projeto.Cliente.CampoObrigatorioException;

public class ControladorCadastroSaidaDeVeiculos {

	private IRpositorioCadastroSaidaDeVeiculos repositorioCadastroSaidaVeiculo;
	
	//construtor
	public ControladorCadastroSaidaDeVeiculos(){
		this.repositorioCadastroSaidaVeiculo = new RepositorioCadastroSaidaDeVeiculos();
	}
	
	
   //METODO CADASTRAR
	public void cadastrarSaidaDeVeiculos(CadastroSaidaDeVeiculos saidaVeiculo) throws SaidaDeVeiculosJaCadastradaException,
																					  IllegalArgumentException,
																					  CampoObrigatorioException{
		
		if(saidaVeiculo == null)throw new IllegalArgumentException("Cadastro de saida de veiculo invalido");
		if(saidaVeiculo.getData().equals("")) throw new CampoObrigatorioException("data");
		
		
		this.repositorioCadastroSaidaVeiculo.cadastrarSaidaDeVeiculo(saidaVeiculo);
	}
	
	
	//METODO ATUALIZAR
	public void atualizarSaidaDeVeiculo(CadastroSaidaDeVeiculos saidaVeiculo) throws SaidaDeVeiculoNaoEncontradaException,
																					 CampoObrigatorioException{
		
		
		this.repositorioCadastroSaidaVeiculo.atualizarSaidaDeVeiculo(saidaVeiculo);
	}
	
	
	//METOFO REMOVER
	public boolean removerSaidaDeVeiculo(CadastroSaidaDeVeiculos codigoLocacao){
		return this.repositorioCadastroSaidaVeiculo.removerSaidaDeVeiculo(codigoLocacao);
	}
	
	
	//METOFO PROCURAR
	public CadastroSaidaDeVeiculos procurarSaidaDeVeiculo(CadastroSaidaDeVeiculos codigoLocacao){
		CadastroSaidaDeVeiculos locacao;
		
		locacao = this.repositorioCadastroSaidaVeiculo.procurarSaidaDeVeiculo(codigoLocacao);
		return locacao;
	}
	
	
	//METODO LISTAR  
	public ArrayList<CadastroSaidaDeVeiculos> listarSaidaVeiculo(){
		return this.repositorioCadastroSaidaVeiculo.listarSaidaDeVeiculo();
	}
}// fim da classe
