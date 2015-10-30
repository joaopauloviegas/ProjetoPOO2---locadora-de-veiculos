package com.fafica.projeto.Funcionario;

import com.fafica.projeto.Endereco.CampoObrigatorioException;
import com.fafica.projeto.Endereco.ControladorEndereco;
import com.fafica.projeto.Endereco.EnderecoJaCadastradoException;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;

public class ControladorFuncionario {
	
	private IRepositorioFuncionario repositorioFuncionario;
	private ControladorEndereco controladorEndereco;
	
	public ControladorFuncionario(){
		this.repositorioFuncionario = new RepositorioFuncionarioBD();
		this.controladorEndereco = new ControladorEndereco();
	}
	
	public void adicionar(Funcionario funcionario) throws EnderecoJaCadastradoException, CampoObrigatorioException{
		this.repositorioFuncionario.adicionar(funcionario);
		this.controladorEndereco.adicionar(funcionario.getEndereco());
	}
	
	public void atualizar(Funcionario funcionario) throws EnderecoNaoEncontradoException, CampoObrigatorioException{
		this.repositorioFuncionario.atualizar(funcionario);
		this.controladorEndereco.atualizar(funcionario.getEndereco());
	}
	
	public void remover(Integer id){
		
	}//fim do remover
	
	public Funcionario buscar(Integer id){
		return null;
	}//fim do buscar
	
	public Funcionario listar(){
		return null;
	}
	

}
