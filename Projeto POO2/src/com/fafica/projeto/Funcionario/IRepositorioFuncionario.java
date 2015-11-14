package com.fafica.projeto.Funcionario;

import java.util.ArrayList;

public interface IRepositorioFuncionario {
	
	public void adicionar(Funcionario funcionario);
	public void atualizar(Funcionario funcionario);
	public void remover(Integer id);
	public ArrayList<Funcionario> buscar(String cpf);
	public ArrayList<Funcionario> listar();

}
