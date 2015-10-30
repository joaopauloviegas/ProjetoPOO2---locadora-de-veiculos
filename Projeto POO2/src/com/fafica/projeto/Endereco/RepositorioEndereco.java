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
		boolean achou;
		for(int i = 0; i < enderecos.size();i++){
			if(endereco.getId().equals(enderecos.get(i).getId()))achou = true;
			else if(achou = false)throw new EnderecoNaoEncontradoException();
			enderecos.set(i, endereco);
		}//fim do for
				
		
	}//fim do atualizar

	@Override
	public void remover(Integer id)throws EnderecoNaoEncontradoException {
		boolean achou;
		for(int i = 0; i < enderecos.size();i++){
			if(id.equals(enderecos.get(i).getId()))achou = true;
			else if(achou = false)throw new EnderecoNaoEncontradoException();
			
			enderecos.remove(i);
		}
		
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
		Endereco  endereco = null;
		boolean achou;
		for(int i = 0; i < enderecos.size();i++){
			if(id.equals(enderecos.get(i).getId()))achou = true;
			else if(achou = false)throw new EnderecoNaoEncontradoException();
			endereco = enderecos.get(i);
		}
		return endereco;
		
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


	

}
