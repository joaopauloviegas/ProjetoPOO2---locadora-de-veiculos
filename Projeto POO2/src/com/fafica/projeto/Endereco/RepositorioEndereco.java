package com.fafica.projeto.Endereco;

import java.util.ArrayList;

public class RepositorioEndereco implements IRepositorioEndereco {
	ArrayList<Endereco> enderecos;
	private int id;	
	
	public RepositorioEndereco(){
		enderecos = new ArrayList<Endereco>();
		id = 1;
	}
	
	
	@Override
	public void adicionar(Endereco endereco)throws EnderecoJaCadastradoException {
			if(this.existe(endereco.getId())) throw new EnderecoJaCadastradoException();
		    endereco.setId(id);	
			enderecos.add(endereco);
			id++;
	}

	@Override
	public void atualizar(Endereco endereco) throws EnderecoNaoEncontradoException {
		int i = getIndice(endereco.getId());
		if(i == -1)throw new EnderecoNaoEncontradoException();
		
		
	}//fim do atualizar

	@Override
	public void remover(Integer id)throws EnderecoNaoEncontradoException {
		int i = getIndice(id);
		if(i == -1)throw new EnderecoNaoEncontradoException();
		for(Endereco end2 : enderecos){
			if(id == end2.getId()){
				enderecos.remove(end2);
			}//fim do if
		}//fim do for
	}//fim do remover

	@Override
	public ArrayList<Endereco> listar() {
		ArrayList<Endereco> listarEnderecos = new ArrayList<Endereco>();
		for(int i = 0; i < listarEnderecos.size(); i++){
			listarEnderecos.add(enderecos.get(i));
		}
		return listarEnderecos;
	}

	@Override
	public Endereco buscar(Integer id)throws EnderecoNaoEncontradoException {
		Endereco endereco = null;
		int i = getIndice(id);
		if(i == -1)throw new EnderecoNaoEncontradoException();
		
		return enderecos.get(i);
	}//fim do buscar


	@Override
	public boolean existe(Integer id) {
		boolean resposta = false;
		for(int i = 0; i < enderecos.size(); i++){
			if(id == enderecos.get(i).getId()) resposta = true;
			else resposta = false;
		} 
		
		return resposta;
	}


	@Override
	public int getIndice(Integer id) {
		int resposta = -1;
		boolean achou = false;
		for(int i = 0; !achou && ( i< enderecos.size());i++){
			if(enderecos.get(i).getId().equals(id)){
				resposta = i;
				achou = true;
			}//fim do if
		}//fim do for
		return resposta;
	}

}
