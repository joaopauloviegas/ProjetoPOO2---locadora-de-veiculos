package com.fafica.projeto.Endereco;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorEndereco {
	
	private IRepositorioEndereco repositorioEndereco;
	
	public ControladorEndereco(){
		this.repositorioEndereco = new RepositorioEnderecoBD();
	}
	
	public void adicionar(Endereco endereco)throws EnderecoJaCadastradoException,
													CampoObrigatorioException, SQLException{
		if(endereco == null)throw new IllegalArgumentException("Endereco inválido");
		if(endereco.getBairro().equals(""))throw new CampoObrigatorioException();
		
		this.repositorioEndereco.adicionar(endereco);
	}//fim do atualizar
	
	public void atualizar(Endereco endereco)throws EnderecoNaoEncontradoException,CampoObrigatorioException{
		if(endereco == null) throw new IllegalArgumentException("Endereco inválido");
		if(endereco.getBairro().equals("")) throw new CampoObrigatorioException();
		
		this.repositorioEndereco.atualizar(endereco);
	}//fim do atualizar
	
	public void remover(String cpf)throws EnderecoNaoEncontradoException{
		this.repositorioEndereco.remover(cpf);
	}//fim do remover
	
	public Endereco buscar(String cpf)throws EnderecoNaoEncontradoException{
		//ArrayList<Endereco> lista = new ArrayList<>();
		return  this.repositorioEndereco.buscar(cpf);
		//return lista;
	}//fim do buscar
	
	public ArrayList<Endereco> listar(){
		ArrayList<Endereco> listar = new ArrayList<>();
		listar = this.repositorioEndereco.listar();
		return listar;
	}//fim do listar
	
	

}
