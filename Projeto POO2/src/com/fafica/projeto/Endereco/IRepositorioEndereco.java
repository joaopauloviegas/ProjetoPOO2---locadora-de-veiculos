package com.fafica.projeto.Endereco;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioEndereco {

	
	public void adicionar(Endereco endereco)throws EnderecoJaCadastradoException, SQLException;
	public void atualizar(Endereco endereco)throws EnderecoNaoEncontradoException;
	public ArrayList<Endereco> buscar(String cpf)throws EnderecoNaoEncontradoException;
	public void remover(String cpf)throws EnderecoNaoEncontradoException;
	public ArrayList<Endereco> listar();
	
	
}
