package com.fafica.projeto.CadastroDeReserva;

public class CadastroDeReservaNaoEncontradoException extends Exception {
	
	public CadastroDeReservaNaoEncontradoException(){
		super("Reserva não encontrada!");
	}

}
