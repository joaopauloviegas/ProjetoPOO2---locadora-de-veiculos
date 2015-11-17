package com.fafica.projeto.Cliente;

import java.util.ArrayList;

import com.fafica.projeto.Endereco.ControladorEndereco;
import com.fafica.projeto.Endereco.EnderecoJaCadastradoException;
import com.fafica.projeto.util.ValidarCPF;

public class ControladorCliente {

	private IRepositorioCliente repositorioClienteBD;
	private ControladorEndereco controladorEndereco;
	
	//controlador
	public ControladorCliente(){
		this.repositorioClienteBD = new RepositorioClienteBD();
		this.controladorEndereco = new ControladorEndereco();
	}
	
	//METODO CADASTRAR
	public void cadastarCliente(Cliente cliente) throws ClienteJaCadastradoException, 
														CPFInvalidoException,
														CampoObrigatorioException,
														IllegalArgumentException, EnderecoJaCadastradoException, com.fafica.projeto.Endereco.CampoObrigatorioException
														{
		if(!ValidarCPF.validaCPF(cliente.getCpf())) throw new CPFInvalidoException();
		if(cliente == null) throw new IllegalArgumentException("Cliente invalido");
		if(cliente.getNome().equals("")) throw new CampoObrigatorioException("nome");
		this.repositorioClienteBD.cadastrarCliente(cliente);
		this.controladorEndereco.adicionar(cliente.getEndereco());
	}
	
	
	//METODO ATUALIZAR
	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException,
														 CPFInvalidoException,
														 CampoObrigatorioException{
		
		//if(!ValidarCPF.validaCPF(cliente.getCpf())) throw new CPFInvalidoException();
		if(cliente.getNome().equals("")) throw new CampoObrigatorioException("nome");
		this.repositorioClienteBD.atualizarCliente(cliente);
	}
	
	
	//METODO REMOVER
	public boolean removerCliente(String cpf)throws ClienteNaoEncontradoException, 
													CPFInvalidoException{
		
	  if(!ValidarCPF.validaCPF(cpf)) throw new CPFInvalidoException();
		
	  return this.repositorioClienteBD.removerCliente(cpf);
	}
	
	
	//METOFO PROCURAR
	public Cliente procurarCliente(String cpf)throws ClienteNaoEncontradoException, 
													 CPFInvalidoException{
		/*
		String cpf;
		Cliente cliente;
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		if(!ValidarCPF.validaCPF(cpf)) throw new CPFInvalidoException();
		else{
			cliente = this.repositorioClienteBD.procurarCliente(cliente);
		}
		return cliente;
		*/
	return	this.repositorioClienteBD.procurarCliente(cpf);
	//return null;
	}
	
	
	//METODO LISTAR
	public ArrayList<Cliente> listarCliente(){
		
		return this.repositorioClienteBD.listarCliente();
		
	}
			
			
	
}// fim da classe
