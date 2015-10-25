package com.fafica.projeto.Cliente;

import java.util.ArrayList;

import com.fafica.projeto.util.ValidarCPF;

public class ControladorCliente {

	private IRepositorioCliente repositorioCliente;
	
	//controlador
	public ControladorCliente(){
		this.repositorioCliente = new RepositorioCliente();
	}
	
	//METODO CADASTRAR
	public void cadastarCliente(Cliente cliente) throws ClienteJaCadastradoException, 
														CPFInvalidoException,
														CampoObrigatorioException,
														IllegalArgumentException
														{
		
		if(cliente == null) throw new IllegalArgumentException("Cliente invalido");
		if(cliente.getNome().equals("")) throw new CampoObrigatorioException("nome");
		this.repositorioCliente.cadastrarCliente(cliente);
	}
	
	
	//METODO ATUALIZAR
	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException,
														 CPFInvalidoException,
														 CampoObrigatorioException{
		
		if(!ValidarCPF.validaCPF(cliente.getCpf())) throw new CPFInvalidoException();
		if(cliente.getNome().equals("")) throw new CampoObrigatorioException("nome");
		this.repositorioCliente.atualizarCliente(cliente);
	}
	
	
	//METODO REMOVER
	public boolean removerCliente(String cpf)throws ClienteNaoEncontradoException, 
													CPFInvalidoException{
		
		boolean retorno = false;
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		
		if(!ValidarCPF.validaCPF(cpf)) throw new CPFInvalidoException();
		else{
			retorno =  this.repositorioCliente.removerCliente(cpf);
	   }
	  return retorno;
	}
	
	
	//METOFO PROCURAR
	public Cliente procurarCliente(String cpf)throws ClienteNaoEncontradoException, 
													 CPFInvalidoException{
		Cliente cliente = null;
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		if(!ValidarCPF.validaCPF(cpf)) throw new CPFInvalidoException();
		else{
			cliente = this.repositorioCliente.procurarCliente(cpf);
		}
		return cliente;
		
	}
	
	
	//METODO LISTAR
	public ArrayList<Cliente> listarCliente(){
		
		return this.repositorioCliente.listarCliente();
		
	}
			
			
	
}// fim da classe
