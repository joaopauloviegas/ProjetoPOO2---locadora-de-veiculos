package com.fafica.projeto.Cliente;

public class ClienteNaoEncontradoException extends Exception{

	public ClienteNaoEncontradoException(String msg){
		super(msg);
	}
	
	public ClienteNaoEncontradoException(){
		super ("Cliente não encontrado");
	}
	
}//fim da classe
