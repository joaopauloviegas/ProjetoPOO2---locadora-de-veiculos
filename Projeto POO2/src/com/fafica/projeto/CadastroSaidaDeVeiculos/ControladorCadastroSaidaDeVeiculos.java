package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.util.ArrayList;

import com.fafica.projeto.Cliente.CampoObrigatorioException;

public class ControladorCadastroSaidaDeVeiculos {

	private IRpositorioCadastroSaidaDeVeiculos repositorioCadastroSaidaVeiculoBD;
	
	//construtor
	public ControladorCadastroSaidaDeVeiculos(){
		this.repositorioCadastroSaidaVeiculoBD = new RepositorioCadastroSaidaDeVeiculosBD();
	}
	
	
   //METODO CADASTRAR
	public void cadastrarSaidaDeVeiculos(CadastroSaidaDeVeiculos saidaVeiculo) throws SaidaDeVeiculosJaCadastradaException,
																					  IllegalArgumentException,
																					  CampoObrigatorioException{
		
		if(saidaVeiculo == null)throw new IllegalArgumentException("Cadastro de saida de veiculo invalido");
		if(saidaVeiculo.getData().equals("")) throw new CampoObrigatorioException("data");
		
		
		this.repositorioCadastroSaidaVeiculoBD.cadastrarSaidaDeVeiculo(saidaVeiculo);
	}
	
	
	//METODO ATUALIZAR
	public void atualizarSaidaDeVeiculo(CadastroSaidaDeVeiculos saidaVeiculo) throws SaidaDeVeiculoNaoEncontradaException,
																					 CampoObrigatorioException{
		
		
		this.repositorioCadastroSaidaVeiculoBD.atualizarSaidaDeVeiculo(saidaVeiculo);
	}
	
	
	//METOFO REMOVER
	public boolean removerSaidaDeVeiculo(CadastroSaidaDeVeiculos codigoLocacao){
		return this.repositorioCadastroSaidaVeiculoBD.removerSaidaDeVeiculo(codigoLocacao);
	}
	
	
	//METOFO PROCURAR
	public CadastroSaidaDeVeiculos procurarSaidaDeVeiculo(CadastroSaidaDeVeiculos codigoLocacao){
		CadastroSaidaDeVeiculos locacao;
		
		locacao = this.repositorioCadastroSaidaVeiculoBD.procurarSaidaDeVeiculo(codigoLocacao);
		return locacao;
	}
	
	
	//METODO LISTAR  
	public ArrayList<CadastroSaidaDeVeiculos> listarSaidaVeiculo(){
		return this.repositorioCadastroSaidaVeiculoBD.listarSaidaDeVeiculo();
	}
}// fim da classe
