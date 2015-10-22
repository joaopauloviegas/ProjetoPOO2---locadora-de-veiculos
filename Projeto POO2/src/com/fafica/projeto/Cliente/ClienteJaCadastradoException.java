package com.fafica.projeto.Cliente;

public class ClienteJaCadastradoException extends Exception {

	public ClienteJaCadastradoException(String msg){
		super(msg);
	}
	
	public ClienteJaCadastradoException(){
		super("Cliente ja cadastrado");
	}
}// fim da classe
