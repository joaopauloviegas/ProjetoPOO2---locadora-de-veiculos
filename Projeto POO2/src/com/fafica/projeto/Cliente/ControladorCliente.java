package com.fafica.projeto.Cliente;

import java.util.ArrayList;

public class ControladorCliente {

	private IRepositorioCliente repositorioCliente;
	
	public ControladorCliente(){
		this.repositorioCliente = new RepositorioCliente();
	}
	
	public void cadastarCliente(Cliente cliente){
		this.repositorioCliente.cadastrarCliente(cliente);
	}
	
	public void atualizarCliente(Cliente cliente){
		this.repositorioCliente.atualizarCliente(cliente);
	}
	
	public boolean removerCliente(String cpf){
		return this.repositorioCliente.removerCliente(cpf);
	}
	
	public Cliente procurarCliente(String cpf){
		Cliente cliente = null;
		
		cliente = this.repositorioCliente.procurarCliente(cpf);
		return cliente;
		
	}
	
	public ArrayList<Cliente> listarCliente(){
		return this.repositorioCliente.listarCliente();
		
	}
			
			
	
}// fim da classe
