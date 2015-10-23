package com.fafica.projeto.Endereco;

import java.util.ArrayList;

public interface IRepositorioEndereco {

	
	public void adicionar(Endereco endereco);
	public void atualizar(Endereco endereco);
	public void remover(Integer id);
	public ArrayList<Endereco> listar();
}
