package com.fafica.projeto.Endereco;

import java.util.ArrayList;

public interface IRepositorioEndereco {

	
	public void adicionar(Endereco endereco)throws EnderecoJaCadastradoException;
	public void atualizar(Endereco endereco)throws EnderecoNaoEncontradoException;
	public Endereco buscar(Integer id)throws EnderecoNaoEncontradoException;
	public void remover(Integer id)throws EnderecoNaoEncontradoException;
	public ArrayList<Endereco> listar();
	public boolean existe(Integer id);
	public int getIndice(Integer id);
}
