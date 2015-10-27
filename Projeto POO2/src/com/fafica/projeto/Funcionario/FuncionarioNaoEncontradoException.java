package com.fafica.projeto.Funcionario;

public class FuncionarioNaoEncontradoException extends Exception {

	public FuncionarioNaoEncontradoException(){
		super("Funcionario não encontrado!");
	}
}
