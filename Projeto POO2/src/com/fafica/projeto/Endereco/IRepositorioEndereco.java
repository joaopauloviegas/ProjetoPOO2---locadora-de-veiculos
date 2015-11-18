package com.fafica.projeto.Endereco;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioEndereco {

	
	public void adicionar(Endereco endereco)throws EnderecoJaCadastradoException, SQLException;
	public void atualizar(Endereco endereco)throws EnderecoNaoEncontradoException;
	public Endereco buscar(Integer id)throws EnderecoNaoEncontradoException;
	public void remover(Integer id)throws EnderecoNaoEncontradoException;
	public ArrayList<Endereco> listar();
	public boolean existe(Integer id);
	
}
