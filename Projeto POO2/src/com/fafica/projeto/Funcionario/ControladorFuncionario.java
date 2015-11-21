package com.fafica.projeto.Funcionario;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto.Cliente.CPFInvalidoException;
import com.fafica.projeto.Endereco.CampoObrigatorioException;
import com.fafica.projeto.Endereco.ControladorEndereco;
import com.fafica.projeto.Endereco.EnderecoJaCadastradoException;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.util.ValidarCPF;

public class ControladorFuncionario {
	
	private IRepositorioFuncionario repositorioFuncionario;
	
	
	public ControladorFuncionario(){
		this.repositorioFuncionario = new RepositorioFuncionarioBD();
		
	}
	
	public void adicionar(Funcionario funcionario) throws IllegalArgumentException, EnderecoJaCadastradoException, CampoObrigatorioException, CPFInvalidoException, SQLException{
		if(funcionario == null) throw new IllegalArgumentException("Cliente inv[alido");
		//if(!ValidarCPF.validaCPF(funcionario.getCpf())) throw new CPFInvalidoException();
		if(funcionario.getNome().equals("")) throw new CampoObrigatorioException();
		
		this.repositorioFuncionario.adicionar(funcionario);		
		
	}
	
	public void atualizar(Funcionario funcionario) throws  CampoObrigatorioException, CPFInvalidoException{
		if(funcionario == null) throw new IllegalArgumentException("Cliente inv[alido");
		if(!ValidarCPF.validaCPF(funcionario.getCpf())) throw new CPFInvalidoException();
		if(funcionario.getNome().equals("")) throw new CampoObrigatorioException();
		
		this.repositorioFuncionario.atualizar(funcionario);
		
	}
	
	public void remover(String cpf) throws CPFInvalidoException,FuncionarioNaoEncontradoException {
		
		this.repositorioFuncionario.remover(cpf);
		
	}//fim do remover
	
	public Funcionario buscar(String cpf){
		return repositorioFuncionario.buscar(cpf);
	}//fim do buscar
	
	public ArrayList<Funcionario> listar(){
		ArrayList<Funcionario> lista = null;
		lista = this.repositorioFuncionario.listar();
		return lista;
	}
	

}
