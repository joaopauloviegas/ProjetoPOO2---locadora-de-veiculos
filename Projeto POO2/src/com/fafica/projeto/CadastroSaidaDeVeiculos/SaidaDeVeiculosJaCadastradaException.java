package com.fafica.projeto.CadastroSaidaDeVeiculos;

public class SaidaDeVeiculosJaCadastradaException extends Exception {

	public SaidaDeVeiculosJaCadastradaException(String msg){
		super(msg);
	}
	
	public SaidaDeVeiculosJaCadastradaException(){
		super("Saida de veiculos j� cadastrada");
	}
}// fim da classe
