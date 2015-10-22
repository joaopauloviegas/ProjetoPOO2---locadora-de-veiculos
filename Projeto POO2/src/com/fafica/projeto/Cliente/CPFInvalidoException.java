package com.fafica.projeto.Cliente;

public class CPFInvalidoException extends Exception {
	
	public CPFInvalidoException(String msg){
		super(msg);
	}
	
	public CPFInvalidoException(){
		super("CPF invalido!");
	}

}// fim da classe
