package com.fafica.projeto.CadastroDeReserva;

import java.util.ArrayList;

public interface IRepositorioCadastroDeReserva {
	
	public void adicionar(CadastroDeReserva cadastrodeReserva) throws CadastroDeReservaJaCadastradaException;
	public void remover(Integer id) throws CadastroDeReservaNaoEncontradoException;
	public void atualizar(CadastroDeReserva cadastrodeReserva) throws CadastroDeReservaNaoEncontradoException;
	public ArrayList<CadastroDeReserva> buscar(Integer id) throws CadastroDeReservaNaoEncontradoException;
	public ArrayList<CadastroDeReserva> listar();

}
