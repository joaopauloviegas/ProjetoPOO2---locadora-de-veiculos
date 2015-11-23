package com.fafica.projeto.CadastroDeReserva;

import java.util.ArrayList;

public interface IRepositorioCadastroDeReserva {
	
	public void adicionar(CadastroDeReserva cadastrodeReserva) throws CadastroDeReservaJaCadastradaException;
	public void remover(double valor) throws CadastroDeReservaNaoEncontradoException;
	public void atualizar(CadastroDeReserva cadastrodeReserva) throws CadastroDeReservaNaoEncontradoException;
	public CadastroDeReserva buscar(double valor) throws CadastroDeReservaNaoEncontradoException;
	public ArrayList<CadastroDeReserva> listar();

}
