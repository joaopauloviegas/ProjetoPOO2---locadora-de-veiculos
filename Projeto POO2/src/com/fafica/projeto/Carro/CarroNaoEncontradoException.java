package com.fafica.projeto.Carro;

public class CarroNaoEncontradoException extends Exception {

	public CarroNaoEncontradoException(String msg){
		super (msg);
	}
	
	public CarroNaoEncontradoException(){
		super("Carro n�o encontrado!");
	}
}// fim da classe
