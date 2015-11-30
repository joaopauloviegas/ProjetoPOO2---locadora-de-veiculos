package com.fafica.projeto.Funcionario;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RepositorioFuncionarioIO implements IRepositorioFuncionario {

	Path path = Paths.get("C:/ads/eclipse/RepositorioIO/rep.txt");

	
	@Override
	public void adicionar(Funcionario funcionario) throws FuncionarioJaCadastradoException, CPFInvalidoException {
		
		
	}

	@Override
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String cpf) throws FuncionarioNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario buscar(String cpf) throws FuncionarioNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Funcionario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

}
