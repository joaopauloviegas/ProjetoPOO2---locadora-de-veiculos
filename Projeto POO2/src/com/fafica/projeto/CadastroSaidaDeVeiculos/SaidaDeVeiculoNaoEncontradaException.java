package com.fafica.projeto.CadastroSaidaDeVeiculos;

public class SaidaDeVeiculoNaoEncontradaException extends Exception {

	public SaidaDeVeiculoNaoEncontradaException(String msg){
		super(msg);
	}
	
	public SaidaDeVeiculoNaoEncontradaException(){
		super("Saida de veiculo não encontrada!");
	}
	
}// fim da classe
