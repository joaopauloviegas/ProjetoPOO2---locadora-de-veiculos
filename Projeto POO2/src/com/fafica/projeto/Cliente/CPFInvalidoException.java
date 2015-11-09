package com.fafica.projeto.Cliente;

import javax.swing.JOptionPane;

public class CPFInvalidoException extends Exception {
	
	public CPFInvalidoException(String msg){
		super(msg);
	}
	
	public CPFInvalidoException(){
		super("CPF invalido!");
	JOptionPane.showMessageDialog(null, "CPF invalido!","ERRO", JOptionPane.ERROR_MESSAGE);
	}

}// fim da classe
