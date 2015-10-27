package com.fafica.projeto.Funcionario;

public class ControladorFuncionario {
	
	private IRepositorioFuncionario repositorioFuncionario;
	
	public ControladorFuncionario(){
		this.repositorioFuncionario = new RepositorioFuncionarioBD();
	}
	
	public void adicionar(Funcionario funcionario){
		this.repositorioFuncionario.adicionar(funcionario);
	}
	

}
