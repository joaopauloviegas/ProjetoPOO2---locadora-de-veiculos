package com.fafica.projeto.Carro;

public class CarroJaCadastradoException extends Exception {

	public CarroJaCadastradoException(String msg){
		super(msg);
	}
	
	public CarroJaCadastradoException(){
		super("Carro ja cadastrado!");
	}
}// fim da classe

