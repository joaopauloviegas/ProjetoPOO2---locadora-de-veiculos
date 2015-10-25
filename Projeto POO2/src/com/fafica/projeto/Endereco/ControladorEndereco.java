package com.fafica.projeto.Endereco;

import java.util.ArrayList;

public class ControladorEndereco {
	
	private IRepositorioEndereco repositorioEndereco;
	
	public ControladorEndereco(){
		this.repositorioEndereco = new RepositorioEndereco();
	}
	
	public void adicionar(Endereco endereco)throws EnderecoJaCadastradoException,
													CampoObrigatorioException{
		if(endereco == null)throw new IllegalArgumentException("Endereco inválido");
		if(endereco.getBairro().equals(""))throw new CampoObrigatorioException();
		
		this.repositorioEndereco.adicionar(endereco);
	}//fim do atualizar
	
	public void atualizar(Endereco endereco)throws EnderecoNaoEncontradoException,CampoObrigatorioException{
		if(endereco == null) throw new IllegalArgumentException("Endereco inválido");
		if(endereco.getBairro().equals("")) throw new CampoObrigatorioException();
		
		this.repositorioEndereco.atualizar(endereco);
	}//fim do atualizar
	
	public void remover(Integer id)throws EnderecoNaoEncontradoException{
		this.repositorioEndereco.remover(id);
	}//fim do remover
	
	public Endereco buscar(Integer id)throws EnderecoNaoEncontradoException{
		return this.repositorioEndereco.buscar(id);
	}//fim do buscar
	
	public ArrayList<Endereco> listar(){
		return this.repositorioEndereco.listar();
	}//fim do listar
	
	

}
