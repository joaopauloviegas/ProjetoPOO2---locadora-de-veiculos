package com.fafica.projeto.Funcionario;

import java.util.ArrayList;

public interface IRepositorioFuncionario {
	
	public void adicionar(Funcionario funcionario)throws FuncionarioJaCadastradoException,CPFInvalidoException;
	public void atualizar(Funcionario funcionario);
	public void remover(String cpf);
	public Funcionario buscar(String cpf);
	public ArrayList<Funcionario> listar();
	public boolean existe(String cpf);

}
