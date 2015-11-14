package com.fafica.projeto.Funcionario;

import java.util.ArrayList;

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
	
	public void remover(Integer id) throws EnderecoNaoEncontradoException{
		this.repositorioFuncionario.remover(id);
		this.controladorEndereco.remover(id);
	}//fim do remover
	
	public ArrayList<Funcionario> buscar(String cpf){
		ArrayList<Funcionario> lista = null;
		lista = this.repositorioFuncionario.buscar(cpf);
		return lista;
	}//fim do buscar
	
	public ArrayList<Funcionario> listar(){
		ArrayList<Funcionario> lista = null;
		
		return null;
	}
	

}
