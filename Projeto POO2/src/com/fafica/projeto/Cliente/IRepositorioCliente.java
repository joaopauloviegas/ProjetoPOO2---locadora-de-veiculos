package com.fafica.projeto.Cliente;

import java.util.ArrayList;

public interface IRepositorioCliente {

	public void cadastrarCliente(Cliente cliente);
	public void atualizarCliente(Cliente cliente);
	public boolean removerCliente(Cliente cliente);
	public Cliente procurarCliente(Cliente cliente);
	public ArrayList<Cliente> listarCliente();
}// fim da interface
