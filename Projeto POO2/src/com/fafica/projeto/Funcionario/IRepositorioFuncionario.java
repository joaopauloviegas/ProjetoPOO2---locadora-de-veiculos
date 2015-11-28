package com.fafica.projeto.Funcionario;

import java.util.ArrayList;

public interface IRepositorioFuncionario {
	
	public void adicionar(Funcionario funcionario)throws FuncionarioJaCadastradoException,CPFInvalidoException;
	public void atualizar(Funcionario funcionario)throws FuncionarioNaoEncontradoException;
	public void remover(String cpf)throws FuncionarioNaoEncontradoException;
	public Funcionario buscar(String cpf)throws FuncionarioNaoEncontradoException;
	public ArrayList<Funcionario> listar();
	public boolean existe(String cpf);

}
