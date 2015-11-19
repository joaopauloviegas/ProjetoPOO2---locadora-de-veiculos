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
		System.out.println("controlador");
	}
	
	
	//METODO ATUALIZAR
	public void atualizarSaidaDeVeiculo(CadastroSaidaDeVeiculos saidaVeiculo) throws SaidaDeVeiculoNaoEncontradaException,
																					 CampoObrigatorioException{
		
		
		this.repositorioCadastroSaidaVeiculoBD.atualizarSaidaDeVeiculo(saidaVeiculo);
	}
	
	
	//METOFO REMOVER
	public boolean removerSaidaDeVeiculo(int id){
		return this.repositorioCadastroSaidaVeiculoBD.removerSaidaDeVeiculo(id);
	}
	
	
	//METOFO PROCURAR
	public CadastroSaidaDeVeiculos procurarSaidaDeVeiculo(String placa){
		
		
		return this.repositorioCadastroSaidaVeiculoBD.procurarSaidaDeVeiculo(placa);
		
	}
	
	
	//METODO LISTAR  
	public ArrayList<CadastroSaidaDeVeiculos> listarSaidaVeiculo(){
		return this.repositorioCadastroSaidaVeiculoBD.listarSaidaDeVeiculo();
	}
}// fim da classe
