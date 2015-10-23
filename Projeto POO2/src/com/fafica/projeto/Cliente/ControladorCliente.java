package com.fafica.projeto.Cliente;

import java.util.ArrayList;

public class ControladorCliente {

	private IRepositorioCliente repositorioCliente;
	
	//controlador
	public ControladorCliente(){
		this.repositorioCliente = new RepositorioCliente();
	}
	
	//metodo cadastrar cliente
	public void cadastarCliente(Cliente cliente) throws ClienteJaCadastradoException, CPFInvalidoException{
		this.repositorioCliente.cadastrarCliente(cliente);
	}
	
	
	
	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException,CPFInvalidoException{
		this.repositorioCliente.atualizarCliente(cliente);
	}
	
	public boolean removerCliente(String cpf)throws ClienteNaoEncontradoException, CPFInvalidoException{
		return this.repositorioCliente.removerCliente(cpf);
	}
	
	public Cliente procurarCliente(String cpf)throws ClienteNaoEncontradoException, CPFInvalidoException{
		Cliente cliente = null;
		
		cliente = this.repositorioCliente.procurarCliente(cpf);
		return cliente;
		
	}
	
	public ArrayList<Cliente> listarCliente() throws ClienteNaoEncontradoException{
		return this.repositorioCliente.listarCliente();
		
	}
			
			
	
}// fim da classe
