package com.fafica.projeto.Funcionario;

public interface IRepositorioFuncionario {
	
	public void adicionar(Funcionario funcionario);
	public void atualizar(Funcionario funcionario);
	public void remover(Integer id);
	public Funcionario buscar(Integer id);
	public Funcionario listar();

}
